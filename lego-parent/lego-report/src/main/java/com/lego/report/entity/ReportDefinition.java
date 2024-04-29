package com.lego.report.entity;

import com.lego.core.data.hibernate.BaseEntity;
import com.lego.core.util.StringUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;

@Setter
@Getter
@Entity
@Table(name = "report_definition")
public class ReportDefinition extends BaseEntity {

    private String dataSource;
    private boolean enable;
    private String sqlText;
    private int maxExportSize;
    private String creatorCode;
    private int sn;

    protected ReportDefinition() {
    }

    public ReportDefinition(String name) {
        super(name);
    }

    @Override
    protected void doBuildReadableSnapshot(Map<String, String> attributes) {
        attributes.put("编码", StringUtil.toString(code));
        attributes.put("姓名", StringUtil.toString(name));
        attributes.put("数据源", StringUtil.toString(dataSource));
        attributes.put("序列", StringUtil.toString(sn));
        attributes.put("是否生效", enable ? "是" : "否");
        attributes.put("SQL脚本", StringUtil.toString(sqlText));
        attributes.put("最大导出数量", StringUtil.toString(maxExportSize));
        attributes.put("创建人", StringUtil.toString(creatorCode));
    }
}
