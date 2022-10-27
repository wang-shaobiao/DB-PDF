package com.wang.db2pdf.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface DemoMapper {
    /**
     * 根据数据库名称获取数据库中表的名称和注释
     *
     * @param tableName
     * @return
     */
    //这里用到${} 一般表名
    @Select("select table_name ,table_comment from information_schema.tables where table_schema = #{dbName};")
    List<Map<String, Object>> getAllTableNames(@Param("dbName") String dbName);

    /**
     * 描述：根据数据库名称获取数据库中表的名称和注释
     * @param dbName
     * @return
     */
    @Select("select " +
            "COLUMN_NAME field, " +
            "COLUMN_TYPE types, " +
            "is_nullable as isnull," +
            "column_key as iskey, " +
            "COLUMN_COMMENT comment " +
            "from " +
            "INFORMATION_SCHEMA.COLUMNS " +
            "where " +
            "table_schema = #{dbName} " +
            "and table_name = #{tableName}; ")
    List<Map<String, Object>> getTableColumnDetail(@Param("tableName")String tableName,@Param("dbName") String dbName);
}
