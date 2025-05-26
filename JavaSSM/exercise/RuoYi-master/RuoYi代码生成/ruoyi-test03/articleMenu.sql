-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章信息管理', '2000', '1', '/business/article', 'C', '0', 'business:article:view', '#', 'admin', sysdate(), '', null, '文章信息管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章信息管理查询', @parentId, '1',  '#',  'F', '0', 'business:article:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章信息管理新增', @parentId, '2',  '#',  'F', '0', 'business:article:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章信息管理修改', @parentId, '3',  '#',  'F', '0', 'business:article:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章信息管理删除', @parentId, '4',  '#',  'F', '0', 'business:article:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('文章信息管理导出', @parentId, '5',  '#',  'F', '0', 'business:article:export',       '#', 'admin', sysdate(), '', null, '');
