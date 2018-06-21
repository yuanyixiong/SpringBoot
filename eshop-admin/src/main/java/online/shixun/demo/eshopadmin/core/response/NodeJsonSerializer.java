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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

/**
 * 请求响应：treeview 插件节点状态转换控制
 *
 * @param <T>
 */
public class NodeJsonSerializer<T> extends JsonSerializer<Node<T>> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void serialize(Node<T> node, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        logger.info("递归数据序列化--开始");
        recursion(jsonGenerator, node);
        logger.info("递归数据序列化--结束");
    }

    private JsonGenerator recursion(JsonGenerator jsonGenerator, Node<T> node) throws IOException {
        jsonGenerator.writeStartObject();

        //控制节点数据，排除生成空数据
        if (Objects.nonNull(node.getId())) {
            jsonGenerator.writeStringField("id", node.getId());
        }
        if (Objects.nonNull(node.getText())) {
            jsonGenerator.writeStringField("text", node.getText());
        }
        if (Objects.nonNull(node.getSelectedIcon())) {
            jsonGenerator.writeStringField("selectedIcon", node.getSelectedIcon());
        }
        if (Objects.nonNull(node.isSelectable())) {
            jsonGenerator.writeBooleanField("selectable", node.isSelectable());
        }
        //节点状态控制
        if (Objects.nonNull(node.getState())) {
            jsonGenerator.writeObjectField("state", node.getState());
        }

        //验证节点是否有子节点，存在则递归
        if (Objects.nonNull(node.getNodes()) && node.getNodes().size() > 0) {
            jsonGenerator.writeArrayFieldStart("nodes");
            for (Node<T> nextNode : node.getNodes()) {
                recursion(jsonGenerator, nextNode);
            }
            jsonGenerator.writeEndArray();
        }
        jsonGenerator.writeEndObject();
        return jsonGenerator;
    }
}
