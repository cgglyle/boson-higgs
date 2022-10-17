/*
 * Copyright (c) 2022 cgglyle and other authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.cgglyle.boson.higgs.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.cgglyle.boson.higgs.api.BaseService;
import io.github.cgglyle.boson.higgs.api.Username;
import io.github.cgglyle.boson.higgs.model.BaseEntity;
import io.github.cgglyle.boson.higgs.model.BaseUpdateEntity;
import io.github.cgglyle.boson.higgs.model.BaseUserEntity;
import io.github.cgglyle.boson.higgs.model.BaseUserUpdateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 顶级Service实现类
 *
 * @author lylecgg
 */
@RequiredArgsConstructor
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity>
        extends ServiceImpl<M, T> implements BaseService<T> {

    @Nullable
    private final Username username;

    /**
     * 根据实体存储一条数据
     *
     * @param entity 实体
     * @return <code>true</code>成功<br><code>false</code>失败
     */
    @Override
    public boolean save(T entity) {
        entity.setIsStatus(false);
        return super.save(entity);
    }

    /**
     * 根据实体更新一条数据
     *
     * @param entity 实体
     * @return <code>true</code>成功<br><code>false</code>失败
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean updateById(T entity) {
        if (entity instanceof BaseUserUpdateEntity tempEntity) {
            tempEntity.setUpdateTime(LocalDateTime.now());
            if (username != null) {
                tempEntity.setUpdateUserName(username.getUsername());
            }
            return super.updateById((T) tempEntity);
        }
        if (entity instanceof BaseUpdateEntity tempEntity) {
            tempEntity.setUpdateTime(LocalDateTime.now());
            return super.updateById((T) tempEntity);
        }
        if (username != null && entity instanceof BaseUserEntity tempEntity) {
            tempEntity.setUpdateUserName(username.getUsername());
            return super.updateById((T) tempEntity);
        }
        return super.updateById(entity);
    }

    @Override
    public boolean update(Wrapper<T> wrapper) {
        if (wrapper instanceof UpdateWrapper) {
            ((UpdateWrapper<T>) wrapper).set("update_time", LocalDateTime.now());
            return super.update(wrapper);
        }
        return super.update(wrapper);
    }

    /**
     * 根据ID删除一条数据
     *
     * @param id 主键id
     * @return <code>true</code>成功<br><code>false</code>失败
     */
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
}
