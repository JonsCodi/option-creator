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
package br.com.tetrabit.jira.plugins.oc.model.pojo;

import java.io.Serializable;

public class GroupDTO implements Serializable {

  private long id;
  private String name;
  private CustomFieldDTO[] customFieldDTOS;
  private PermissionDTO[] permissionDTOS;
  private Boolean status;

  GroupDTO(){
    super();
  }

  public GroupDTO(String name, Boolean status){
    this.name = name;
    this.status = status;
  }

  public long getId(){
    return this.id;
  }

  public void setId(long id){
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomFieldDTO[] getCustomFieldDTOS() {
    return customFieldDTOS;
  }

  public void setCustomFieldDTOS(CustomFieldDTO[] customFieldDTOS) {
    this.customFieldDTOS = customFieldDTOS;
  }

  public PermissionDTO[] getPermissionDTOS() {
    return permissionDTOS;
  }

  public void setPermissionDTOS(PermissionDTO[] permissionDTOS) {
    this.permissionDTOS = permissionDTOS;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
