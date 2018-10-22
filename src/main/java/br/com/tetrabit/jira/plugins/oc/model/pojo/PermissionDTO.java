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

public class PermissionDTO implements Serializable {

  private long id;
  private GroupDTO groupDTO;
  private String userGroup;
  private String user;
  private String scenario;
  private Boolean status;

  public PermissionDTO() {
    super();
  }


  public PermissionDTO(GroupDTO groupDTO, String userGroup, String user, String scenario, Boolean status) {
    this.groupDTO = groupDTO;
    this.userGroup = userGroup;
    this.user = user;
    this.scenario = scenario;
    this.status = status;
  }

  public long getId(){
    return this.id;
  }

  public void setId(long id){
    this.id = id;
  }

  public GroupDTO getGroupDTO() {
    return groupDTO;
  }

  public void setGroupDTO(GroupDTO groupDTO) {
    this.groupDTO = groupDTO;
  }

  public String getUserGroup() {
    return userGroup;
  }

  public void setUserGroup(String userGroup) {
    this.userGroup = userGroup;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getScenario() {
    return scenario;
  }

  public void setScenario(String scenario) {
    this.scenario = scenario;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}

































