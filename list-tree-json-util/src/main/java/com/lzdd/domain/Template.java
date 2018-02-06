package com.lzdd.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author Created by fei.tang@hand-china.com on 2018/1/25.
 * @description 内容交易平台,模板实体类映射
 */
public class Template implements Serializable{
/*
     @Id - 用于字段级别，标记这个字段是一个主键，默认生成的名称是“_id”
     @Document - 用于类，以表示这个类需要映射到数据库，您也可以指定映射到数据库的集合名称
     @DBRef - 用于字段，以表示它将使用com.mongodb.DBRef进行存储。
     @Indexed - 用于字段，表示该字段需要如何创建索引
     @CompoundIndex - 用于类，以声明复合索引
     @GeoSpatialIndexed - 用于字段，进行地理位置索引
     @TextIndexed - 用于字段，标记该字段要包含在文本索引中
     @Language - 用于字段，以设置文本索引的语言覆盖属性。
     @Transient - 默认情况下，所有私有字段都映射到文档，此注解将会去除此字段的映射
     @PersistenceConstructor - 标记一个给定的构造函数，即使是一个protected修饰的，在从数据库实例化对象时使用。构造函数参数通过名称映射到检索的DBObject中的键值。
     @Value - 这个注解是Spring框架的一部分。在映射框架内，它可以应用于构造函数参数。这允许您使用Spring表达式语言语句来转换在数据库中检索的键值，然后再用它来构造一个域对象。
     为了引用给定文档的属性，必须使用以下表达式：@Value("#root.myProperty")，root要指向给定文档的根。
     @FieldMon - 用于字段，并描述字段的名称，因为它将在MongoDB BSON文档中表示，允许名称与该类的字段名不同。
     @Version - 用于字段锁定，保存操作时检查修改。初始值是0，每次更新时自动触发。
*/
    //主键
    private Long id;

    private String templateId;

    //大类
    private String segment1;

    //中类
    private String segment2;

    //小类
    private String segment3;

    //发布人ID
    private Integer releaseBy;

    //发布日期
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date releaseDate;

    //是否审批
    private String approveFlag;

    //审核日期
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss") //后端传值
    private Date approveDate;

    //微信号
    private String wechat;

    //QQ号
    private String qq;

    //电话
    private String mobile;

    //上传视频路径
    private String viedoPath;

    //上传图片路径
    private String imagePath;

    //更新人ID
    private Integer lastUpdateBy;

    //更新日期
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss") //后端传值
    private Date lastUpdateDate;

    //模板拥有的步骤
    private List<StepMon> steps;


    public Template() {
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getSegment1() {
        return segment1;
    }

    public void setSegment1(String segment1) {
        this.segment1 = segment1;
    }

    public String getSegment2() {
        return segment2;
    }

    public void setSegment2(String segment2) {
        this.segment2 = segment2;
    }

    public String getSegment3() {
        return segment3;
    }

    public void setSegment3(String segment3) {
        this.segment3 = segment3;
    }

    public Integer getReleaseBy() {
        return releaseBy;
    }

    public void setReleaseBy(Integer releaseBy) {
        this.releaseBy = releaseBy;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getApproveFlag() {
        return approveFlag;
    }

    public void setApproveFlag(String approveFlag) {
        this.approveFlag = approveFlag;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getViedoPath() {
        return viedoPath;
    }

    public void setViedoPath(String viedoPath) {
        this.viedoPath = viedoPath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }



    public List<StepMon> getSteps() {
        return steps;
    }

    public void setSteps(List<StepMon> steps) {
        this.steps = steps;
    }

    public Template(String templateId, String segment1, String segment2, String segment3) {
        this.templateId = templateId;
        this.segment1 = segment1;
        this.segment2 = segment2;
        this.segment3 = segment3;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", templateId=" + templateId +
                ", segment1='" + segment1 + '\'' +
                ", segment2='" + segment2 + '\'' +
                ", segment3='" + segment3 + '\'' +
                ", releaseBy=" + releaseBy +
                ", releaseDate=" + releaseDate +
                ", approveFlag='" + approveFlag + '\'' +
                ", approveDate='" + approveDate + '\'' +
                ", wechat='" + wechat + '\'' +
                ", qq='" + qq + '\'' +
                ", mobile='" + mobile + '\'' +
                ", viedoPath='" + viedoPath + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", lastUpdateBy=" + lastUpdateBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", steps=" + steps +
                '}';
    }
}


