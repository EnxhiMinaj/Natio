package com.junction.natio.core.utils;

import java.util.List;

/**

 */
public interface IBeanMapper<Entity, DTO> {
    Entity mapToEntity(DTO viewModel);

    DTO mapToDTO(Entity entity);

    List<Entity> mapToEntity(List<DTO> dtoList);

    List<DTO> mapToDTO(List<Entity> entityList);
}
