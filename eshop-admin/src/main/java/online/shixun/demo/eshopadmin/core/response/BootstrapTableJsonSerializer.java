/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.core.response;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import online.shixun.demo.eshopadmin.core.model.BaseModel;
import online.shixun.demo.eshopadmin.model.EshopRoleModel;
import online.shixun.demo.eshopadmin.model.EshopUserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 请求响应：treeview 插件节点状态转换控制
 *
 * @param <T>
 */
public class BootstrapTableJsonSerializer<T extends BaseModel> extends JsonSerializer<PageResultForBootstrapTable<T>> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void serialize(PageResultForBootstrapTable<T> table, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        logger.info("列表数据序列化--开始");
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("total", table.getTotal());
        jsonGenerator.writeArrayFieldStart("rows");

        //拿到拥有的
        Map<String, Boolean> checkeds = new HashMap<>();//拥有的
        table.getCheckeds().stream().forEach(model -> {
            checkeds.put(model.getId(), true);
        });
        //遍历所有
        for (T row : table.getRows()) {
            //若所有列表中的某一个，当前checkeds拥有则 state =true 反之 false
            recursion(jsonGenerator, row, Objects.nonNull(checkeds.get(row.getId())));
        }

        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
        logger.info("列表数据序列化--结束");
    }

    private JsonGenerator recursion(JsonGenerator jsonGenerator, T row, boolean state) throws IOException {
        jsonGenerator.writeStartObject();
        //当前的确实拥有
        jsonGenerator.writeBooleanField("state", state);
        jsonGenerator.writeStringField("id", row.getId());
        if (row instanceof EshopRoleModel) {
            jsonGenerator.writeStringField("roleName", ((EshopRoleModel) row).getRoleName());
            jsonGenerator.writeStringField("roleDescription", ((EshopRoleModel) row).getRoleDescription());
        } else if (row instanceof EshopUserModel) {
            jsonGenerator.writeStringField("userEmail", ((EshopUserModel) row).getUserEmail());
            jsonGenerator.writeStringField("userLoginName", ((EshopUserModel) row).getUserLoginName());
            jsonGenerator.writeStringField("userNicakName", ((EshopUserModel) row).getUserNicakName());
            jsonGenerator.writeStringField("userRealName", ((EshopUserModel) row).getUserRealName());
        }
        jsonGenerator.writeEndObject();
        return jsonGenerator;
    }
}
