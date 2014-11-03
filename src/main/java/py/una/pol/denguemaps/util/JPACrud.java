/*
 * TICPY Framework
 * Copyright (C) 2012 Plan Director TICs
 *
----------------------------------------------------------------------------
 * Originally developed by SERPRO
 * Demoiselle Framework
 * Copyright (C) 2010 SERPRO
 *
----------------------------------------------------------------------------
 * This file is part of TICPY Framework.
 *
 * TICPY Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 *
----------------------------------------------------------------------------
 * Este archivo es parte del Framework TICPY.
 *
 * El TICPY Framework es software libre; Usted puede redistribuirlo y/o
 * modificarlo bajo los términos de la GNU Lesser General Public Licence versión 3
 * de la Free Software Foundation.
 *
 * Este programa es distribuido con la esperanza que sea de utilidad,
 * pero sin NINGUNA GARANTÍA; sin una garantía implícita de ADECUACION a cualquier
 * MERCADO o APLICACION EN PARTICULAR. vea la GNU General Public Licence
 * más detalles.
 *
 * Usted deberá haber recibido una copia de la GNU Lesser General Public Licence versión 3
 * "LICENCA.txt", junto con este programa; en caso que no, acceda a <http://www.gnu.org/licenses/>
 * o escriba a la Free Software Foundation (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */

package py.una.pol.denguemaps.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.ticpy.tekoporu.DemoiselleException;
import org.ticpy.tekoporu.annotation.Name;
import org.ticpy.tekoporu.configuration.Configuration;
import org.ticpy.tekoporu.pagination.Pagination;
import org.ticpy.tekoporu.pagination.PaginationContext;
import org.ticpy.tekoporu.template.PaginatedCrud;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.util.Beans;
import org.ticpy.tekoporu.util.Reflections;
import org.ticpy.tekoporu.util.ResourceBundle;

/**
 * JPA specific implementation for Crud interface.
 * 
 * @param <T>
 *            bean object type
 * @param <I>
 *            bean id type
 * @author SERPRO
 * @see Crud
 */
public class JPACrud<T, I> implements PaginatedCrud<T, I> {

	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;

	private Pagination pagination;
	
	private boolean paginated = true;

	@Inject
	@Name("demoiselle-jpa-bundle")
	private Instance<ResourceBundle> bundle;

	private Class<T> beanClass;

	protected Class<T> getBeanClass() {
		if (this.beanClass == null) {
			this.beanClass = Reflections.getGenericTypeArgument(this.getClass(), 0);
		}

		return this.beanClass;
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		return getEntityManager().getCriteriaBuilder();
	}

	protected EntityManager getEntityManager() {
		if (this.entityManager == null) {
			this.entityManager = Beans.getReference(EntityManager.class);
		}

		return this.entityManager;
	}

	public Pagination getPagination() {
		return pagination;
	}
	
	public void setPagination(Pagination pag) {
		this.pagination = pag;
	}

	protected CriteriaQuery<T> createCriteriaQuery() {
		return getCriteriaBuilder().createQuery(getBeanClass());
	}

	protected Query createQuery(final String ql) {
		return getEntityManager().createQuery(ql);
	}

	protected void handleException(Throwable cause) throws Throwable {
		if (cause instanceof TransactionRequiredException) {
			String message = bundle.get().getString("no-transaction-active", "frameworkdemoiselle.transaction.class",
					Configuration.DEFAULT_RESOURCE);

			throw new DemoiselleException(message, cause);

		} else {
			throw cause;
		}
	}

	@Override
	@Transactional
	public void insert(final T entity) {
		getEntityManager().persist(entity);
	}

	@Override
	@Transactional
	public void delete(final I id) {
		T entity = getEntityManager().getReference(getBeanClass(), id);
		getEntityManager().remove(entity);
	}

	@Override
	@Transactional
	public void update(final T entity) {
		getEntityManager().merge(entity);
	}

	@Override
	public T load(final I id) {
		return getEntityManager().find(getBeanClass(), id);
	}

	@Override
	public List<T> findAll() {
		CriteriaBuilder builder = getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getBeanClass());
		Root<T> entity = query.from(getBeanClass());
		query.select(entity);
		
		return findByCriteriaQuery(query);
	}
	
	public List<T> findAll(String sortField, boolean dirAsc) {
		CriteriaBuilder builder = getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getBeanClass());
		final Root<T> entity = query.from(getBeanClass());
		
		final List<Order> orders = new ArrayList<Order>();
		
		if (dirAsc) {
			Path<T> p = entity.get(sortField);
			final Order ord = builder.asc(p);
			orders.add(ord);
		} else {
			Path<T> p = entity.get(sortField);
			final Order ord = builder.desc(p);
			orders.add(ord);
		}
		
		query.orderBy(orders).select(entity);
		
		return findByCriteriaQuery(query);
	}
	
	public List<T> findAll(String sortField, boolean dirAsc, T filtro) {
		final CriteriaBuilder builder = getCriteriaBuilder();
		final CriteriaQuery<T> query = createCriteriaByExample(filtro);
		final Root<T> entity = (Root<T>) query.getRoots().toArray()[0];
		final List<Order> orders = new ArrayList<Order>();
		
		if (dirAsc) {
			Path<T> p = entity.get(sortField);
			final Order ord = builder.asc(p);
			orders.add(ord);
		} else {
			Path<T> p = entity.get(sortField);
			final Order ord = builder.desc(p);
			orders.add(ord);
		}
		
		query.orderBy(orders);

		return findByCriteriaQuery(query);
	}
	
	public Long countAll() {
		String query = createCountQuery("select this from " + getBeanClass().getSimpleName() + " this");
		Query q = getEntityManager().createQuery(query);
		return (Long) q.getSingleResult();
	}
	
	public Long countAll(T example) {
		CriteriaQuery<T> criteriaQuery = createCriteriaByExample(example);
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		countQuery.select(builder.count(countQuery.from(getBeanClass())));
		countQuery.where(criteriaQuery.getRestriction());
		getEntityManager().createQuery(countQuery);

		return (Long) getEntityManager().createQuery(countQuery).getSingleResult();
	}

	/**
	 * Search JPQL integrated into the context of paging
	 * 
	 * @param jpql
	 *            - query in syntax JPQL
	 * @return a list of entities
	 */
	protected List<T> findByJPQL(String jpql) {
		TypedQuery<T> listQuery = getEntityManager().createQuery(jpql, getBeanClass());

		if (getPagination() != null) {
			String countQuery = createCountQuery(jpql);
			Query query = getEntityManager().createQuery(countQuery);
			Number cResults = (Number) query.getSingleResult();
			getPagination().setTotalResults(cResults.intValue());
			listQuery.setFirstResult(getPagination().getFirstResult());
			listQuery.setMaxResults(getPagination().getPageSize());
		}

		return listQuery.getResultList();
	}
	
	
	protected List<T> findByJPQL(String jpql, /*List<String> names,*/ String name, List<Object> parameters) {
		
		TypedQuery<T> listQuery = getEntityManager().createQuery(jpql, getBeanClass());
		/*for (int i = 0; i < names.size(); i++) {
			listQuery.setParameter(names.get(i), parameters.get(i));
		}*/
		listQuery.setParameter(name, parameters);

		if (getPagination() != null) {
			String countQuery = createCountQuery(jpql);
			
			Query query = getEntityManager().createQuery(countQuery);
			/*for (int i = 0; i < names.size(); i++) {
				query.setParameter(names.get(i), parameters.get(i));
			}*/
			query.setParameter(name, parameters);
			Number cResults = (Number) query.getSingleResult();
			getPagination().setTotalResults(cResults.intValue());
			listQuery.setFirstResult(getPagination().getFirstResult());
			listQuery.setMaxResults(getPagination().getPageSize());
		}

		return listQuery.getResultList();
	}

	/**
	 * Search CriteriaQuery integrated into the context of paging
	 * 
	 * @param criteriaQuery
	 *            - structure CriteriaQuery
	 * @return a list of entities		query.where(order.toArray(new Predicate[0])).select(entity);
	 */
	public List<T> findByCriteriaQuery(CriteriaQuery<T> criteriaQuery) {
		TypedQuery<T> listQuery = getEntityManager().createQuery(criteriaQuery);

		if (getPagination() != null) {
			CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
			countQuery.select(builder.count(countQuery.from(getBeanClass())));
			if (criteriaQuery.getRestriction() != null) {
				countQuery.where(criteriaQuery.getRestriction());
			}
			getEntityManager().createQuery(countQuery);
			getPagination().setTotalResults((int) (getEntityManager().createQuery(countQuery).getSingleResult() + 0));
			listQuery.setFirstResult(getPagination().getFirstResult());
			listQuery.setMaxResults(getPagination().getPageSize());
		}

		return listQuery.getResultList();
	}

	/**
	 * Converts a query into a count query
	 * 
	 * @param query
	 * @return
	 */
	private String createCountQuery(String query) {
		Matcher matcher = Pattern.compile("[Ss][Ee][Ll][Ee][Cc][Tt](.+)[Ff][Rr][Oo][Mm]").matcher(query);

		if (matcher.find()) {
			String group = matcher.group(1).trim();
			query = query.replaceFirst(group, "COUNT(" + group + ")");
			matcher = Pattern.compile("[Oo][Rr][Dd][Ee][Rr](.+)").matcher(query);

			if (matcher.find()) {
				group = matcher.group(0);
				query = query.replaceFirst(group, "");
			}

			return query;

		} else {
			throw new DemoiselleException(bundle.get().getString("malformed-jpql"));
		}
	}

	/**
	 * Retrieves a list of entities based on a single example instance of it.
	 * <p>
	 * See below a sample of its usage:
	 * 
	 * <pre>
	 * Employee example = new Employee();
	 * example.setId(12345);
	 * return (List&lt;Employee&gt;) findByExample(example);
	 * </pre>
	 * 
	 * @param example
	 *            an entity example
	 * @return a list of entities
	 */
	public List<T> findByExample(final T example) {
		final CriteriaQuery<T> criteria = createCriteriaByExample(example);
		
		return findByCriteriaQuery(criteria);
	}

	/**
	 * Support method which will be used for construction of criteria-based queries.
	 * 
	 * @param example
	 *            an example of the given entity
	 * @return an instance of {@code CriteriaQuery}
	 */
	private CriteriaQuery<T> createCriteriaByExample(final T example) {
		final CriteriaBuilder builder = getCriteriaBuilder();
		final CriteriaQuery<T> query = builder.createQuery(getBeanClass());
		final Root<T> entity = query.from(getBeanClass());
		final EntityType<T> type = getEntityManager().getMetamodel().entity(getBeanClass());

		final List<Predicate> predicates = new ArrayList<Predicate>();
		final Field[] fields = example.getClass().getDeclaredFields();

		for (Field field : fields) {
			if (!field.isAnnotationPresent(Column.class)
					&& !field.isAnnotationPresent(Basic.class)
					&& !field.isAnnotationPresent(Enumerated.class)
					/*&& !field.isAnnotationPresent(OneToOne.class)
					&& !field.isAnnotationPresent(ManyToOne.class)
					&& !field.isAnnotationPresent(OneToMany.class)*/) {
				String name = field.getName();
				continue;
			}
			
			String name = field.getName();
			Object value = null;
			
			try {
				field.setAccessible(true);
				value = field.get(example);

			} catch (IllegalArgumentException e) {
				continue;

			} catch (IllegalAccessException e) {
				continue;

			}

			if (value == null) {
				continue;
			}

			
			if (value instanceof String) {
				final Predicate pred = builder.like(
											builder.lower(
													entity.get(type.getDeclaredSingularAttribute(field.getName(), String.class))
											)
											,"%" + ((String) value).toLowerCase() + "%"
										);
				predicates.add(pred);
			} else {
				Path<T> path = entity.get(field.getName());
				final Predicate pred = builder.equal(path, value);
				predicates.add(pred);
			}
			
			//System.out.println(field.getName() + " clase: " + value.getClass());
			//if (value instanceof String) {
			//	System.out.println("Es cadena");
			//}
			//final Predicate pred = builder.equal(entity.get(field.getName()), value);
			//predicates.add(pred);
			
			
		}
		
		return query.where(predicates.toArray(new Predicate[0])).select(entity);
	}
	

	public boolean isPaginated() {
		return this.paginated;
	}

	public void setPaginated(boolean paginated) {
		this.paginated = paginated;
	}
	
	public void setPage(int currentPage, int pageSize) {
		this.getPagination().setPage(currentPage, pageSize);
	}
	
	public List<T> findAllOrderBy(String sortProperty, String sortDirection) {
		return findByJPQL("select this from " + getBeanClass().getSimpleName()
				+ " this " + " order by " + sortProperty + " " + sortDirection);
	}

}
