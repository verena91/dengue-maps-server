PGDMP     ;    2            
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
   TABLE DATA                     public       postgres    false    175   �       �          0    286190    cuartiles_por_distrito 
   TABLE DATA                     public       postgres    false    174   �       �           2606    286205    cuartiles_por_barrio_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY cuartiles_por_barrio
    ADD CONSTRAINT cuartiles_por_barrio_pkey PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.cuartiles_por_barrio DROP CONSTRAINT cuartiles_por_barrio_pkey;
       public         postgres    false    175    175            �           2606    286197    cuartiles_por_distrito_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY cuartiles_por_distrito
    ADD CONSTRAINT cuartiles_por_distrito_pkey PRIMARY KEY (id);
 \   ALTER TABLE ONLY public.cuartiles_por_distrito DROP CONSTRAINT cuartiles_por_distrito_pkey;
       public         postgres    false    174    174            �   �  x�ř�n�6��~
���տ]����hiH�B���^���@QN� y��Xg(�+Kj���,-���7ߐJ;i;�tgğ?_�?����ៗׇ?__�_ħ�ע���O��o�������חo��O߮�j/�����9��	�t4\��n�OD�����o�)!uP�&�#��H��-Q����FT�Z�Ҫ��S)�g�P0ۖr�%��59�cD}#Z٩nÔw�R\��P�{㤐�?�J9Q*8-�U���b
�\j�ˑc��4��o�3@1��p�D�,1z����0R`5��)O܋��W3����BR��"Ga�U���_@ۆ�b۰�y��:�G�6l$$�V�>�U�,n�FCn�bKɭ�>�����؈H���f$}s�ۜ4�hl���B���6�@c�/�5"���rPU�r��jj���<�f��!m�?s�VI�r���T}P��O��qN-f2��%1�L�A�w�.�����wԺ_4�]���氵҈9�5���ro�'ZIt"R�B�J��<�p�v�����^c�Rڠ'ˡ��{��΢ȷW$�{��d��$F���`a��O;l6>�}����,�[�g>����5x+�qb�hl���eËB��TZa0�,k����SX�r���$�N��G�mjtѢ6�<�LRn'���OQx籘d�E/��J �,v��j��pҮ���aP����+��0�^o�꾕�m��{�wMy=k��`����F���MP̻;I�ϲ�1k�q]�K��b�a�yS8!�=(rΡ����᝿�$��JjA��Щfe�I�H�S�����ZCO���j��tb�n�H���ѡB-+;�D�s��z44��0��nn�v��9G��!H�J	��6�JB������7%}>v�cD��U�mP;pS �^��a�j�K��]=%u��rX��� 
�^Z�nO'9�vȑ�a�)����HT�@�G]�C��c�,�i3ߤ�U�SR�&7��o�Jw���\N>A$m��Ӌ��ɏXnG��������un�.�;[ue�a�@?���lŔEJa�f�������Y<��tb��T�_ҕ��,�Y�Nc�[f��ÁBtViUB9���A/��dÕ 5R��`5�s���ާ��X;�̥N�|,<�cລ�%Y>I�31h����s���vr��`xn�rx�����K�q.Օ ��V���x
g%:1�:�HǜTɔ�Z8M�V�!�t�_K1�tq�/Z��`      �   �  x�͝�r�����)�ڸD�r�(ZC��t�sق$��"J�D~�y��-g�X P��sF_T��7��� ^�u�ya�}C�s^��ooU��!?���\�?�_с��o�#-�{�~����[Sv���p�){:�o՟�3�Sw��d��NU���>����(L}�}m��,�:��������3�h��ʓ�\T�ve�u��-iA���j�r�Q~��5�L�{���?�56M:�H�����6�wX��SsKJ�'uQ���P~1�:�E-�;��ۀ�_L��5�lwA24�2��_h�Ϥ(�1��㇡9Nk���oQ�03�4el�I􀞢��]��;����Y����Ar�:�6� ��IL��0\˰�Z#q��!ڸ�8B+�G��� �+/KeGk�%Xc��gʤ�&��Z�I'*��ʤ�xNUʵ�1��a�p����zat�`���gܱ�����y�����@ԅ
��3Fk7f����$�j^�=��]Q����&���9f �*]�g���Є8��؃��>%K���x��g�;0��ؚ���t&e~*H%�Ό�jZfOد`����q�Q5 V��Z��%�0�0�Y��Xӳ�����(5��q�� �M���;R_dH�Q�HS4潞p��ɠ�H#Mв8{N��	#M�|o�EǋBp��-և�(ڌ�[���Gc��M'ͼQY�,�i������ ����Y�ե:�	h�"���3�|���i� �=�Z�yp�����]uړ�:�͉��
�)0c[��bl���yd�G*c[G�X��bN�XN��0k�5xj��4��h����b~u$�&�Z:3օ,�U{r!��U�^�S�@��u-l�w�������I袶��|Gw���2�ua����E
|��~���.o<(_Һ$싥�k\�&��1�3AnϙMt�K�]��C"&��=6��-���.g�`��EѮ�5�6኶nH����]����q2���ٸ�:��w��K�Ɨ�'S�sYտ��͙��4�/j�Ɠ8r�@+oN��S����9/�;4օ��H��?hCk��X�x��i�t(�k��m^h�3��f9/��pjI�^�r7.{	CC�e�3y�� LG
bS�#�5Щ�O!���t���ᔥ�k�Q��R��L�|��|B
���dk*��Ǐ�w�QDY�xķ%�wr�jh��Je쏟�j�/>��i9I�e�$����Ft&K҆�*��4
�w��z��]��w����j�{�d$"ȷM�+��e�Q��(z��UtK�g0��D�������46�@Y J��xf3�u<��QK,vC����
���)X�I��lz�@�����8L�c�&��{��}<�D��n���sKam�~U�OCX[�a�a��u�^ԭ+�-�qe���
Z�
m�s���rS?Z3��no��[�% �l�*Z��=�r��&�v�k�*[�S�����8ߣHv�
\;ۢ�������n�����8�`��C��:�F>��1�N!��x/T��	bϹW5X�7�k����B���X�hY�wRC�UE��sT�����%��x��#_���B���L��Å��tq�w��Y1T��|3����u�e4�`�XȈˆ�=�O�6��p(��1��-���D��ؒ��շ/�K�������楬�-#,��8ʑL)R0^<�M���L�p,#'�;8g`'2�c���k�2w�A6(;�ej�5��9��"U#^'p����C.V|�Q����E�o��{R�r�F=��4�KZI�ofi<I�D#�;�C��KMr�
�[~&%
�;�(E���A���qx�c��-�b��'��yhq��X�����NZ�F�����,�!h�	K4͐WԲCWw�T����=.���P(e�z���-�g��;�58˶zi�X�U_Te�V��/�+K����X��ZO��@["�lY�|���P�=�py�-kU�+�O�j���KU��L>���#òe��)�meh����u�߻��#P�9Ə��GY#Y�^W;���Ўd�r�����Y#Y��(�[G���v�Ʈ��ّ,]��z�Z��SE����;8HY�2r�\�!���U�V��d�ڰ��.ɂվC��� �N�)g	5�S��ɶh��P&l��KҜy-A�D/�.2�T9��{��{�`x��� ih�������ʺ��[��@;�i٬
H��s �6�N Yg=�9yhs�TG�EU� ��Z,���ݥ� h�*:\l�vXu>���m�[�Y��E����n�_P�͏����=y%pr%:[H�!�<ұJ�Y^�q��F��K��a��"^(��R��<��ϑX�����Վ����}!�����1v�����l@�
 P��e	��D�51:Uuk����pQ&��="SM��6�5�WxQ�T/Q���.ZG�7�K���a��ؖ��፮�c������_Z`8�t+o�R�a |�&[��or�i��ש�Z���*�,Q`gK��>�����^��񭂢���9p��@�#&�܎mk�{�̧	�%�½�ݭ�r��m��[X�N"f�ұ?O�|I�~�^=��[>3T��������%
HQ�+shW.X�������,�vRa�W6Z���B���??� �Fw���u&�E���2��<ՙ?~�}�,�Sg�B;�~B���A��_��C�7�
ɬG��|!h��0��m�#|	©�'W;R����{��Z�ϵ>�&<�Ѻ����:��`{�M�l�+��{$��w��h=*���=� t����N;Z��- �{$Ϋ��?�mP��\���ț6���p��%�o��-6y�N����A�q�^/�m[1��&jt���V���OE3�S���Z31?�E'�ԡ��m���!����X�_	���h'*�� ������j��rx�T�֐X�4G1��5$RqyS��.TV�45�L�=Tu�z.�'?<`]�x��mw���b�P����%No��	��������h�&.��	@k�d��K�Ŋ{����Z��6aм�=�tM����7�";��N�h�ޞ�.����o[��#��b�/H[�DX+֫��K��h�с�����?܉�������K�*I�����9:��p���&K�o���kT��zQ��˫�;�٢1G��i��D[!��_���\�M�mk�";U�֜���K��6��Dn�ߩ{QV �������>F�'^ �Ruۚ��s\^Aٶ�*i�q�ӗ�B����-��3���p���
�7rn���@2f[*�8�Z�+ueV��V����=�Q�/��� FW����.�o��p;*l[�l��8���gvV�m��cþ��'R�J.�YS|?
c�.=�,/'G���=���M[����x!�:8�0�	o����A�t��(��'�! �� �-:z��^�,����@\�����$.����^�	=�3J�
^X!�������p�⎞vW'�<T��_�!qmC�0Z��:���qY�V�����53�q�ŕ�,}!u��rxQ���e~�r��?4V��Zt
��<N����=�v��4�2��]F9=��G6��GDE~|w����}^Xݟ�Z�\��&��>�%ye�!}�᭵��>b��GZT�ZoR�R����%��1r��К��}[�̚ȸ}�2^r����4��.#�0fw�6\�����x�'���!��8X�ؕs=���ڢ�H�K�Uw�� \�\f��c�"�G(���Q�C��)����\�$�=E:�?�`���=~�0o���H���̸����X(��T�W��ڮ`���ŷ���S���[D�u;�rY��c3��н���Ց� `"������y=�v0RE����Hܗ�Q����� �U�������|n3Q��	a����{Ʊ<� T"'�^q��G�~kK�m&����<�T�,�
Yyࢪ��Y,Z�l�N��"W�l�΁�6R1?���R���TH���Z ��H��m�ѵ7��p{�Y,a��N�_��;N     