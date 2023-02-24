package icu.liuwisdom.business.vo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import icu.liuwisdom.business.entity.LogRecord;
import icu.liuwisdom.business.entity.LogRecordMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>
 * 日志记录表
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "日志记录Vo对象", description = "日志记录表")
public class LogRecordVo extends LogRecord {
    @ApiModelProperty(value = "日志留言信息树")
    private List<LogRecordMessageVo> messageTree;

    @ApiModelProperty(value = "日志留言信息")
    private List<LogRecordMessageVo> messages;
}
