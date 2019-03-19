package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USER_OPERATE_LOG")
public class UserOperateLog implements java.io.Serializable {

    /** 版本号 */

    private static final long serialVersionUID = 3322584679786620277L;

 

    /**  */

    private Integer id;

 

    /** 用户id */

    private String custId;

 

    /** 用户名 */

    private String custName;

 

    /** 真实姓名 */

    private String realName;

 

    /** 操作模块 */

    private String moduleName;

 

    /** 操作描述 */

    private String operateDesc;

 

    /** 操作IP */

    private String ipAddress;

 

    /** 操作时间 */

    private Date createTime;

 

    /**

     * 获取

     * 

     * @return 

     */

    @Id

    @GeneratedValue(generator = "idGenerator")

    @GenericGenerator(name = "idGenerator", strategy = "native")

    @Column(name = "ID", unique = true, nullable = false, length = 10)

    public Integer getId() {

        return this.id;

    }

 

    /**

     * 设置

     * 

     * @param id

     */

    public void setId(Integer id) {

        this.id = id;

    }

 

    /**

     * 获取用户id

     * 

     * @return 用户id

     */

    @Column(name = "CUST_ID", nullable = true, length = 255)

    public String getCustId() {

        return this.custId;

    }

 

    /**

     * 设置用户id

     * 

     * @param custId

     *          用户id

     */

    public void setCustId(String custId) {

        this.custId = custId;

    }

 

    /**

     * 获取用户名

     * 

     * @return 用户名

     */

    @Column(name = "CUST_NAME", nullable = true, length = 255)

    public String getCustName() {

        return this.custName;

    }

 

    /**

     * 设置用户名

     * 

     * @param custName

     *          用户名

     */

    public void setCustName(String custName) {

        this.custName = custName;

    }

 

    /**

     * 获取真实姓名

     * 

     * @return 真实姓名

     */

    @Column(name = "REAL_NAME", nullable = true, length = 255)

    public String getRealName() {

        return this.realName;

    }

 

    /**

     * 设置真实姓名

     * 

     * @param realName

     *          真实姓名

     */

    public void setRealName(String realName) {

        this.realName = realName;

    }

 

    /**

     * 获取操作模块

     * 

     * @return 操作模块

     */

    @Column(name = "MODULE_NAME", nullable = true, length = 255)

    public String getModuleName() {

        return this.moduleName;

    }

 

    /**

     * 设置操作模块

     * 

     * @param moduleName

     *          操作模块

     */

    public void setModuleName(String moduleName) {

        this.moduleName = moduleName;

    }

 

    /**

     * 获取操作描述

     * 

     * @return 操作描述

     */

    @Column(name = "OPERATE_DESC", nullable = true, length = 255)

    public String getOperateDesc() {

        return this.operateDesc;

    }

 

    /**

     * 设置操作描述

     * 

     * @param operateDesc

     *          操作描述

     */

    public void setOperateDesc(String operateDesc) {

        this.operateDesc = operateDesc;

    }

 

    /**

     * 获取操作IP

     * 

     * @return 操作IP

     */

    @Column(name = "IP_ADDRESS", nullable = true, length = 255)

    public String getIpAddress() {

        return this.ipAddress;

    }

 

    /**

     * 设置操作IP

     * 

     * @param ipAddress

     *          操作IP

     */

    public void setIpAddress(String ipAddress) {

        this.ipAddress = ipAddress;

    }

 

    /**

     * 获取操作时间

     * 

     * @return 操作时间

     */

    @Column(name = "CREATE_TIME", nullable = true)

    public Date getCreateTime() {

        return this.createTime;

    }

 

    /**

     * 设置操作时间

     * 

     * @param createTime

     *          操作时间

     */

    public void setCreateTime(Date createTime) {

        this.createTime = createTime;

    }

}
