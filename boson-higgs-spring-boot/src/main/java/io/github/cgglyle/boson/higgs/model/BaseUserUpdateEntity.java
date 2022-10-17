package io.github.cgglyle.boson.higgs.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 含更新时间和更新用户名的基类
 *
 * @author Lyle
 * @since 2022/10/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseUserUpdateEntity extends BaseEntity {
    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @Schema(description = "更新用户名")
    @TableField(value = "update_user_name", fill = FieldFill.INSERT_UPDATE)
    private String updateUserName;
}
