/*********************************************************************************************************************
 *
 * COPYRIGHT 2017 TETRABIT DO BRASIL
 *
 * Terms of Use: This source code is licensed under the
 *
 * Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International (CC BY-NC-ND 4.0) license,
 *
 * where a full copy of these terms follow this work in the LICENSE file and is also available at:
 *
 * https://creativecommons.org/licenses/by-nc-nd/4.0/
 *
 * You may not use this source code except in compliance with this License.
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 ********************************************************************************************************************/
package br.com.tetrabit.jira.plugins.oc.ao;

import br.com.tetrabit.jira.plugins.oc.domain.PersistenceManager;
import br.com.tetrabit.jira.plugins.oc.model.Constants.Enums;
import br.com.tetrabit.jira.plugins.oc.model.ao.CustomField;
import br.com.tetrabit.jira.plugins.oc.model.ao.Group;
import br.com.tetrabit.jira.plugins.oc.model.ao.Permission;
import br.com.tetrabit.jira.plugins.oc.model.pojo.CustomFieldDTO;
import br.com.tetrabit.jira.plugins.oc.model.pojo.GroupDTO;
import br.com.tetrabit.jira.plugins.oc.model.pojo.PermissionDTO;
import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.activeobjects.test.TestActiveObjects;
import net.java.ao.EntityManager;
import net.java.ao.test.junit.ActiveObjectsJUnitRunner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.*;

@RunWith(ActiveObjectsJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActiveObjectTest {

  private EntityManager entityManager;

  private ActiveObjects ao;

  private PersistenceManager persistenceManager;

  @Before
  public void setUp(){
    assertNotNull(entityManager);
    ao = new TestActiveObjects(entityManager);
    persistenceManager = new PersistenceManager(null, ao);
  }

  @Test
  public void testCreateGroup(){
    GroupDTO groupDTO = new GroupDTO("Grupo numero 1", Boolean.TRUE);
    ao.migrate(Group.class);
    final Group group = persistenceManager.addGroup(groupDTO);
    groupDTO.setId(group.getID());
    assertTrue(persistenceManager.findAllGroups().size() > 0);
  }

  @Test
  public void testCreateCustomField(){
    GroupDTO groupDTO = new GroupDTO("Grupo numero 1", Boolean.TRUE);
    ao.migrate(Group.class);
    final Group group = persistenceManager.addGroup(groupDTO);
    groupDTO.setId(group.getID());
    assertTrue(persistenceManager.findAllGroups().size() > 0);

    CustomFieldDTO customFieldDTO = new CustomFieldDTO("Lista de Valores 1", 1234, Enums.CASCADING.toString(), groupDTO);
    CustomFieldDTO customFieldDTO2 = new CustomFieldDTO("Lista de Valores 2", 1235, Enums.MULTIPLE.toString(), groupDTO);
    CustomFieldDTO customFieldDTO3 = new CustomFieldDTO("Lista de Valores 3", 1236, Enums.SINGLE.toString(), groupDTO);
    CustomFieldDTO customFieldDTO4 = new CustomFieldDTO("Lista de Valores 4", 1237, Enums.SINGLE.toString(), groupDTO);
    ao.migrate(CustomField.class);
    assertEquals(0, persistenceManager.findAllCustomFields().size());
    persistenceManager.addCustomField(customFieldDTO);
    persistenceManager.addCustomField(customFieldDTO2);
    persistenceManager.addCustomField(customFieldDTO3);
    persistenceManager.addCustomField(customFieldDTO4);
    assertTrue(persistenceManager.findAllCustomFields().size() > 0);
  }

  @Test
  public void testCreatePermission(){
    GroupDTO groupDTO = new GroupDTO("Grupo numero 1", Boolean.TRUE);
    ao.migrate(Group.class);
    final Group group = persistenceManager.addGroup(groupDTO);
    groupDTO.setId(group.getID());
    assertTrue(persistenceManager.findAllGroups().size() > 0);

    final PermissionDTO permissionDTO = new PermissionDTO(groupDTO, "Group User 1, 2, 3", "User 1, user 2, user 3", Enums.EDIT.toString(), Boolean.TRUE);
    final PermissionDTO permissionDTO2 = new PermissionDTO(groupDTO, "Group User 1, 2, 3", "User 1, user 2, user 3", Enums.CREATE.toString(), Boolean.FALSE);
    final PermissionDTO permissionDTO3 = new PermissionDTO(groupDTO, "Group User 1, 2, 3", "User 1, user 2, user 3", Enums.EDIT.toString(), Boolean.TRUE);
    final PermissionDTO permissionDTO4 = new PermissionDTO(groupDTO, "Group User 1, 2, 3", "User 1, user 2, user 3", Enums.CREATE.toString(), Boolean.FALSE);

    ao.migrate(Permission.class);
    List<Permission> permissions = new ArrayList<>();
    assertEquals(0, persistenceManager.findAllPermissions().size());
    permissions.add(persistenceManager.addPermission(permissionDTO));
    permissions.add(persistenceManager.addPermission(permissionDTO2));
    permissions.add(persistenceManager.addPermission(permissionDTO3));
    permissions.add(persistenceManager.addPermission(permissionDTO4));
    assertTrue(persistenceManager.findAllPermissions().size() > 0);

    final CustomFieldDTO customFieldDTO = new CustomFieldDTO("Lista de Valores 1", 1234, Enums.CASCADING.toString(), groupDTO);
    final CustomFieldDTO customFieldDTO2 = new CustomFieldDTO("Lista de Valores 2", 1235, Enums.MULTIPLE.toString(), groupDTO);
    final CustomFieldDTO customFieldDTO3 = new CustomFieldDTO("Lista de Valores 3", 1236, Enums.SINGLE.toString(), groupDTO);
    final CustomFieldDTO customFieldDTO4 = new CustomFieldDTO("Lista de Valores 4", 1237, Enums.SINGLE.toString(), groupDTO);
    ao.migrate(CustomField.class);
    List<CustomField> customFields = new ArrayList<>();
    assertEquals(0, persistenceManager.findAllCustomFields().size());
    customFields.add(persistenceManager.addCustomField(customFieldDTO));
    customFields.add(persistenceManager.addCustomField(customFieldDTO2));
    customFields.add(persistenceManager.addCustomField(customFieldDTO3));
    customFields.add(persistenceManager.addCustomField(customFieldDTO4));
    assertTrue(persistenceManager.findAllCustomFields().size() > 0);

    Arrays.asList(group.getCustomField()).forEach(g->System.out.println(g.getName()));
    Arrays.asList(group.getPermission()).forEach(g->System.out.println(g.getUser()));

  }


}
