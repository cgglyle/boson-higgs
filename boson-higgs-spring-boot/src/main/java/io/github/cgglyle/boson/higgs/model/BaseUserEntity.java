package io.github.cgglyle.boson.higgs.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 含更新用户名的基类
 *
 * @author Lyle
 * @since 2022/10/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseUserEntity extends BaseEntity {
    @Schema(description = "更新用户名")
    @TableField(value = "update_user_name", fill = FieldFill.INSERT_UPDATE)
    private String updateUserName;
}
