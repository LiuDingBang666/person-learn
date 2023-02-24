package icu.liuwisdom.gencode.service.impl;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import icu.liuwisdom.core.exception.BusinessException;
import icu.liuwisdom.gencode.config.GenConfig;
import icu.liuwisdom.gencode.service.GenCodeService;
import icu.liuwisdom.gencode.util.GenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * 代码生成服务
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-18 14:43
 */
@Service
public class GenCodeServiceImpl implements GenCodeService {

    /**
     * 代码生成
     *
     * @author LDB
     * @date 2023-01-18 14:50
     * @version 1.0
     */
    @Override
    public Boolean gen(GenConfig config) {
        check(config);
        GenUtil.genCode(config);
        return true;
    }

    @Override
    public Boolean connection(GenConfig config) {
        check(config);
        try {
            Connection connection = getConnection(config);
            closeConnection(connection);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取连接
     *
     * @param config
     * @return java.sql.Connection
     * @author LDB
     * @date 2023-01-26
     **/
    public Connection getConnection(GenConfig config) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        return connection;
    }


    /**
     * 关闭连接
     *
     * @param connection
     * @author LDB
     * @date 2023-01-26
     **/
    public void closeConnection(Connection connection) throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
        }
    }


    /**
     * 获取表信息
     *
     * @param config
     * @return java.util.List<com.baomidou.mybatisplus.generator.config.po.TableInfo>
     * @author LDB
     * @date 2023-01-26
     **/
    @Override
    public List<TableInfo> tables(GenConfig config) {
        check(config);
        return new ConfigBuilder(null, new DataSourceConfig.Builder(config.getUrl(), config.getUsername(), config.getPassword()).build(),
                null, null, null, null)
                .getTableInfoList();
    }


    private void check(GenConfig config) {
        if (StringUtils.isEmpty(config.getUrl())) {
            throw new BusinessException("数据库地址不能为空");
        }
        if (StringUtils.isEmpty(config.getUsername())) {
            throw new BusinessException("用户名不能为空");
        }
        if (StringUtils.isEmpty(config.getPassword())) {
            throw new BusinessException("密码不能为空");
        }
    }
}
