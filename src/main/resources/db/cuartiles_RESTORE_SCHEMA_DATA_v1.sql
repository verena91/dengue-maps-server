PGDMP     1                
    r        
   denguemaps    9.3.2    9.3.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �            1259    286198    cuartiles_por_barrio    TABLE     �   CREATE TABLE cuartiles_por_barrio (
    id integer NOT NULL,
    barrio character varying,
    area character varying,
    cuartil_uno character varying,
    cuartil_dos character varying,
    cuartil_tres character varying
);
 (   DROP TABLE public.cuartiles_por_barrio;
       public         postgres    false            �            1259    286190    cuartiles_por_distrito    TABLE       CREATE TABLE cuartiles_por_distrito (
    id integer NOT NULL,
    departamento character varying,
    distrito character varying,
    cuartil_uno character varying,
    cuartil_dos character varying,
    cuartil_tres character varying,
    tipo character varying
);
 *   DROP TABLE public.cuartiles_por_distrito;
       public         postgres    false            �          0    286198    cuartiles_por_barrio 
   TABLE DATA                     public       postgres    false    174   �       �          0    286190    cuartiles_por_distrito 
   TABLE DATA                     public       postgres    false    173   �       �           2606    286205    cuartiles_por_barrio_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY cuartiles_por_barrio
    ADD CONSTRAINT cuartiles_por_barrio_pkey PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.cuartiles_por_barrio DROP CONSTRAINT cuartiles_por_barrio_pkey;
       public         postgres    false    174    174            �           2606    286197    cuartiles_por_distrito_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY cuartiles_por_distrito
    ADD CONSTRAINT cuartiles_por_distrito_pkey PRIMARY KEY (id);
 \   ALTER TABLE ONLY public.cuartiles_por_distrito DROP CONSTRAINT cuartiles_por_distrito_pkey;
       public         postgres    false    173    173            �   �  x�ř�n�6��~
���տ]����hiH�B���^���@QN� y��Xg(�+Kj���,-���7ߐJ;i;�tgğ?_�?����ៗׇ?__�_ħ�ע���O��o�������חo��O߮�j/�����9��	�t4\��n�OD�����o�)!uP�&�#��H��-Q����FT�Z�Ҫ��S)�g�P0ۖr�%��59�cD}#Z٩nÔw�R\��P�{㤐�?�J9Q*8-�U���b
�\j�ˑc��4��o�3@1��p�D�,1z����0R`5��)O܋��W3����BR��"Ga�U���_@ۆ�b۰�y��:�G�6l$$�V�>�U�,n�FCn�bKɭ�>�����؈H���f$}s�ۜ4�hl���B���6�@c�/�5"���rPU�r��jj���<�f��!m�?s�VI�r���T}P��O��qN-f2��%1�L�A�w�.�����wԺ_4�]���氵҈9�5���ro�'ZIt"R�B�J��<�p�v�����^c�Rڠ'ˡ��{��΢ȷW$�{��d��$F���`a��O;l6>�}����,�[�g>����5x+�qb�hl���eËB��TZa0�,k����SX�r���$�N��G�mjtѢ6�<�LRn'���OQx籘d�E/��J �,v��j��pҮ���aP����+��0�^o�꾕�m��{�wMy=k��`����F���MP̻;I�ϲ�1k�q]�K��b�a�yS8!�=(rΡ����᝿�$��JjA��Щfe�I�H�S�����ZCO���j��tb�n�H���ѡB-+;�D�s��z44��0��nn�v��9G��!H�J	��6�JB������7%}>v�cD��U�mP;pS �^��a�j�K��]=%u��rX��� 
�^Z�nO'9�vȑ�a�)����HT�@�G]�C��c�,�i3ߤ�U�SR�&7��o�Jw���\N>A$m��Ӌ��ɏXnG��������un�.�;[ue�a�@?���lŔEJa�f�������Y<��tb��T�_ҕ��,�Y�Nc�[f��ÁBtViUB9���A/��dÕ 5R��`5�s���ާ��X;�̥N�|,<�cລ�%Y>I�31h����s���vr��`xn�rx�����K�q.Օ ��V���x
g%:1�:�HǜTɔ�Z8M�V�!�t�_K1�tq�/Z��`      �   �  x�͝ώ�6��y
ޜ ن%۲�=�$�f�5�Ի�%v�0�n&H&2{���[��?"��Y@�iO'�7�b���Ţh{�&�A�����_?���?�����?~���~a���#���7��_���ׯ_̧��~��??������/<?|�������o_~`o G޳���G��e��Z�oBJ`5�L���?��/u����߉4ě��| i�#h�����M��]�f�������B�|gV�բ�)5�fE�;� b��$Z�r���xl�j�QBJ1@5��}�1����=��yj��:$5���7�n��f����Ȫ쇵�%)i$iR�\C�vW;J�]��Z5����������F�v%d܆�f;'�q_����i��TO,�1��jR=�lH�u��~��c�ar�<1��a�T�� ������T_A�P��u�y)�	$3�m���uc5�T�y�:����Ji�#�Z��Fwv�[��ұ�I� ;khkj��62�*��n�t1Nm�F�Z;�7k�f�KA�$bQ�6�b9R+lca�hL�����Z�����&o��a�&׸]�q���%=g��nP%�_���������בKrk˙5�W�s�J�5����fB[1������|�8o���|���E���2�ױ�8K�_����Cl`4i�o4�A��B-��<������ Z~��z�XO\���k~e&{�9m-��	a�����[�����w B�9�	�;n������}�:j۫���.��Y�M����
}�	�ކԖӗ�G�E,F-|�ja �:`�o�
�e�e�����H���Nو�����H}���o���}e�U5(�J5�KIlE��$u�+6�4��w��z4�RT#���=&P`���1�H0�ϋ��~��tO�Ȕ�7�k�H��4��.ĝ}�=3��i���@M 
�J<�}��+!�|�0�IhTN���5�rj�q�顏t�_�	4Ў�����q,�zXԚw0hq��YD�:�!X]�]��֜����WF���-�k8lQM�b�T�n�԰CA�.�N8���2>Ju6n���8����PrOvM��������i�"�C�lFil�Ǌ�3��d���ݦўrM�[Nh����T��v��V��땄V�ѹ�bMg����ن�MzF�jp5nc���S<�9F'՚�W�7��`C�{3R�5���1T�����f����17�J:�K���x�+t��0�Iȷ����R�΃��
Fǣ�X���&���bf뵏j3�F����4<�����:����E��עgE�Ke��GnLj˩Uc��Ƨ��Zީf�x�3D��>� o�A�����Q����b?�Z�Iف/S�i$w̑��ڸ6�ii�'T�lm��`�a���I�u<��V�,A�~�F=6��i��5ه���L��fY摚L��4'ș���в�_�E)�fU��qz�[���$ K�?��K���Gfu�e|YV����R��\�-����b-��q��LE
��/��<��S��u뤡�����eB>n2f[0�@��(˳EZ������}麨�I����d��Z�����}�����Y����Z�J)��Ij��e��� �ߨudd�/P6�T�p6���ad�!�9A�B
�!k8�����/^����P?��,��W-nT�;O�6�Z���i���5�Ⱦt�)���L�N��g�Wr��l����8R��j=�����/^��G�``����uj g 8e��0	u�@	�`+m�Z���&��&Ԓƹ����V���Jv� ۈ�m ��S8U"d���xe	��bZ���"�[�aq>�6jWpg)��X\N�Ѧ��8�"dp&h����M$=I�M
@70S^����Ĩ�+N���8,-V�q��U�Qs��3>?���G�C���CV��9A��h`�a�#݆��B�sn��;���i��٤�|d�"'�G�������*A�s�8��#šh���{a�r���^� �1r�&��fN�]r�"ԭՇQ����M��G�����8�.���"/��#gg�^A�G��ա�t��2���F:����7r#�"ҭ	�Um����H��r�F8���ZD�e@��U+YX`TYo��[��m��
���sU���K�vn�[[g�j|�>M��w�y/j�d�<�=��g�XR�,ƾ�λ��M�&f 7�/É!��.�����7ҥTڻ�L~�_l��ֶP��pF�V�1�4�O�*���Ŭh����m@	�`.b��oP��"fu&*��k�7���G�b�[�Ɋ�xϛ\�d����)W�H�vX�?l�Ѣ�3k%�:�aA�n�}�A�7�Âֵ����ڒ�]жp���^���Ĺ}g�%�[��kJ�mA7|X8�$@�%Pr^�� qB�F��9��s��g�5������ە�R�J�v8W���M��Ω���@�9�r^�'R>�a'��:�����8I�#��6с"��p��GZ�Q�j�ӣ݅��� �^_%���i��&��݇�����,���H���|��zY%���GB��C���y���Ǫe����ב�b�:�����F\�B�/��}�̄_�9��[����4�H�.�	����u�kH+K��[Y��0����_OuG)�c��;�Oĕ�/�~�ke°ϫ��K�9�A��]<���IYq4ǌ�>��41n��$Or��1���B릁Z� ��Ԩ�>�2����j�q9�3͵/���>G�?��C��l"WJwcϪ�-��kȳ]<�Ѿ�;�\A�:���`�/�UM^�ȳ}�k�+(��!$�:�^ɍ�γc����[f�x��:��|�����-�d,�BR���O����wY
�m$�;nl�X�H�&�'��#�Q�瑠M�A�r��n�j}�<f�W���e|'�
���T����1�TƊ%�M�hڊw�1~^N��R?����'�t����&�+��~��rQ^lw�|�k$M���"R�4�����	E��]38��X��_D�p�Ya���"T�Ul��j�7T���1"}����큶M9�5���jEn�D�L��<��Ώ{��>���~��<FM-Vb�Ċ���9b0k�Fh�����h4\�c<r0�}#^�G�X��H+#���z!���찫}O��`���������,Ê��+EC�&�1�t���k����zыA)1_����jj��8�q)��D}����<.�B2~|�ܻY� )��/�[h��g�8�q���J���O��2N{\�̇L��+�x%��xe�^��A��_��Q��b����q2��}�ǅ�n�UiϨ�� �����A���0��q4��$$�������8�qΊG�z����kr?��#�dЍa+�u�G���3��T�ґE��6[".�bX[~���Ŷ�1>�!qd��A����2��I0q?o�KaR�1�3���W��aaqɽ��o�K6Ѝx���~�-��'�8�2���T�%� ��vZ��,'M>!�=m;�\�gVL^��q��U�N�p�4��3��Z:D���G38]rF�'¾��,���p����o�鱨n�1����'^4m�I��B���&�����+Bp)zx���_$?��q�d ;? �=V6-��ǜ:h�c5�V7飩��K����{݌ 7e~K�Hu�U>𮎱���n����5k���6�>A7��5�@�^�d}`����!w�^a#��1�+��(���.=nH�qvd� U�f�h%�U�F�@�l	C̆��H%��*���I�PE�jF@��@���٪ۜN���1K��Z���}�q���     