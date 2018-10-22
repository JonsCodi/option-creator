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
import com.atlassian.activeobjects.tx.Transactional;

import java.util.List;

@Transactional
public interface IPersistenceManager {

  Group addGroup(GroupDTO group);
  Group findGroup(int groupId);
  List<Group> findAllGroups();
  int deleteGroup(int groupId);
  Group updateGroup(GroupDTO group);

  CustomField addCustomField(CustomFieldDTO customField);
  CustomField findCustomField(int customField);
  List<CustomField> findAllCustomFields();
  int deleteCustomField(int customFieldId);
  CustomField updateCustomField(CustomFieldDTO customField);

  Permission addPermission(PermissionDTO permission);
  Permission findPermission(int permissionId);
  List<Permission> findAllPermissions();
  int deletePermission(int permissionId);
  Permission updatePermission(PermissionDTO permission);
}
