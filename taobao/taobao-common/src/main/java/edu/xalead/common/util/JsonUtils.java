package edu.xalead.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.xalead.item.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: HuYi.Zhang
 * @create: 2018-04-24 17:20
 **/
public class JsonUtils {

    public static final ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    @Nullable
    public static String serialize(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    @Nullable
    public static <T> T parse(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    @Nullable
    public static <E> List<E> parseList(String json, Class<E> eClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    @Nullable
    public static <K, V> Map<K, V> parseMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    @Nullable
    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class User{
        String name;
        Integer age;
    }
//    public static void main(String[] args) {
//        Item item=new Item();
//        item.setId(1111);
//        item.setName("克莱恩");
//        item.setPrice(222.2);
//        System.out.println(serialize(item));
//        /***
//         * {"id":1111,"name":"克莱恩","price":222.2}
//         */
//        String json="{\"id\":1111,\"name\":\"克莱恩\",\"price\":222.2}";
//        Item i=parse(json,Item.class);
//        System.out.println(i);
//        json="[1,2,3,4,5]";
//        List<Integer>list=parseList(json,Integer.class);
//        System.out.println(list);
//        json="[{\"id\":1111,\"name\":\"克莱恩\",\"price\":123.2},\n" +
//                "  {\"id\":1111,\"name\":\"kei\",\"price\":123.2},\n" +
//                "  {\"id\":1111,\"name\":\"notyours\",\"price\":123.2}]";
//        List<Item>List=nativeRead(json, new TypeReference<List<Item>>() {});
//        System.out.println(List);
//    }
}
