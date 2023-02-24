package icu.liuwisdom.gencode.constant;

import java.io.File;

/**
 * 代码生成常量配置
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-19 10:38
 */

public interface GenConstant {
    String ENTITY_NAME = "po";

    String MAPPER = "mapper";

    String ENTITY_FILE = "entity.java";
    String SERVICE_FILE = "service.java";
    String SERVICE_IMPL_FILE = "serviceImpl.java";
    String MAPPER_FILE = "mapper.java";
    String XML_FILE = "mapper.xml";
    String CONTROLLER_FILE = "controller.java";

    String GEN_PARENT = "gen";

    String QUERY_TEMPLATE = "query.java.vm";

    String VO_TEMPLATE = "vo.java.vm";

    String QUERY = "Query.java";

    String VO = "Vo.java";


    String DTO = "Dto.java";

    String DTO_TEMPLATE = "dto.java.vm";


    String GEN_OUTPUT = System.getProperty("user.dir") + File.separator + GenConstant.GEN_PARENT;
}
