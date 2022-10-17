package io.github.cgglyle.boson.higgs.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 含更新时间的基类
 *
 * @author Lyle
 * @since 2022/10/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseUpdateEntity extends BaseEntity {
    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
