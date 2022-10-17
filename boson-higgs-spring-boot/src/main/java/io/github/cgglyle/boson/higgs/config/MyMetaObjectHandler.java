package io.github.cgglyle.boson.higgs.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.github.cgglyle.boson.higgs.api.Username;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MybatisPlus Fill自动注入时间配置类
 * <p></p>
 * <h2>注意！</h2>
 * 此配置只能在字段是NULL状态下使用，如果字段不为NULL是无效的！
 *
 * @author lyle
 */
@Component
@RequiredArgsConstructor
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Nullable
    private final Username username;

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        if (username != null) {
            this.strictInsertFill(metaObject, "createUserName", String.class, username.getUsername());
            this.strictUpdateFill(metaObject, "updateUserName", String.class, username.getUsername());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        if (username != null) {
            this.strictUpdateFill(metaObject, "updateUserName", String.class, username.getUsername());
        }
    }
}
