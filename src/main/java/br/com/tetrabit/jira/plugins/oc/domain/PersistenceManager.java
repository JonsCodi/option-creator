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
package br.com.tetrabit.jira.plugins.oc.domain;

import br.com.tetrabit.jira.plugins.oc.model.ao.CustomField;
import br.com.tetrabit.jira.plugins.oc.model.ao.Group;
import br.com.tetrabit.jira.plugins.oc.model.ao.Permission;
import br.com.tetrabit.jira.plugins.oc.model.pojo.CustomFieldDTO;
import br.com.tetrabit.jira.plugins.oc.model.pojo.GroupDTO;
import br.com.tetrabit.jira.plugins.oc.model.pojo.PermissionDTO;
import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.sal.api.message.I18nResolver;
import net.java.ao.DBParam;
import net.java.ao.Query;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.*;

public class PersistenceManager implements IPersistenceManager {

  private Logger log = Logger.getLogger(this.getClass());

  private final I18nResolver i18n;
  private final ActiveObjects ao;

  @Inject
  public PersistenceManager(I18nResolver i18n, ActiveObjects ao) {
    this.i18n = i18n;
    this.ao = checkNotNull(ao);
    log.info("AO Initialized: " + true);
  }

  @Override
  public Group addGroup(GroupDTO groupDTO) {
    log.warn("DoInTransaction");
    Group groupEntity = ao.create(Group.class, new DBParam("NAME", groupDTO.getName()), new DBParam("STATUS", groupDTO.getStatus()));
    groupEntity.save();
    log.info("Created Group: " + groupEntity.getName() + " (" + groupEntity.getID() + ")");
    return groupEntity;
  }

  @Override
  public Group findGroup(int groupId) {
    Query query = Query.select().where("ID = ?", groupId);
    return Arrays.asList(ao.find(Group.class, query)).get(0);
  }

  @Override
  public List<Group> findAllGroups() {
    return Arrays.asList(ao.find(Group.class, Query.select().order("NAME ASC")));

  }

  @Override
  public int deleteGroup(int groupId) {
    return 0;
  }

  @Override
  public Group updateGroup(GroupDTO groupDTO) {
    return null;
  }

  @Override
  public CustomField addCustomField(CustomFieldDTO customFieldDTO) {
    log.warn("DoInTransaction");
    CustomField customFieldEntity = ao.create(CustomField.class, new DBParam("NAME", customFieldDTO.getName()), new DBParam("TYPE", customFieldDTO.getType()), new DBParam("CUSTOM_FIELD_ID", customFieldDTO.getCustomFieldID()));
    Group group = findGroup((int) customFieldDTO.getGroupDTO().getId());
    customFieldEntity.setGroup(group);
    customFieldEntity.save();
    log.info("Created Custom Field: " + customFieldEntity.getName() + " (" + customFieldEntity.getID() + ")");
    return customFieldEntity;
  }

  @Override
  public CustomField findCustomField(int customField) {
    return null;
  }

  @Override
  public List<CustomField> findAllCustomFields() {
    return Arrays.asList(ao.find(CustomField.class, Query.select().order("NAME ASC")));
  }

  @Override
  public int deleteCustomField(int customFieldId) {
    return 0;
  }

  @Override
  public CustomField updateCustomField(CustomFieldDTO customFieldDTO) {
    return null;
  }

  @Override
  public Permission addPermission(PermissionDTO permissionDTO) {
    log.warn("DoInTransaction");
    Permission permissionEntity = ao.create(Permission.class, new DBParam("USER_GROUP", permissionDTO.getUserGroup()), new DBParam("USER", permissionDTO.getUser()), new DBParam("SCENARIO", permissionDTO.getScenario()), new DBParam("STATUS", permissionDTO.getStatus()));
    Group group = findGroup((int) permissionDTO.getGroupDTO().getId());
    permissionEntity.setGroup(group);
    permissionEntity.save();
    log.info("Created Permission: (" + permissionEntity.getID() + ")");
    return permissionEntity;
  }

  @Override
  public Permission findPermission(int permissionId) {
    return null;
  }

  @Override
  public List<Permission> findAllPermissions() {
    return Arrays.asList(ao.find(Permission.class, Query.select().order("USER_GROUP ASC")));
  }

  @Override
  public int deletePermission(int permissionId) {
    return 0;
  }

  @Override
  public Permission updatePermission(PermissionDTO permissionDTO) {
    return null;
  }
}
