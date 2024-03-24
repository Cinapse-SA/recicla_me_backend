package ao.cinapse.recicla_me.http.dtos;

import ao.cinapse.recicla_me.models.Material;

import java.util.UUID;

public class MaterialDTO extends AbstractDTO<Material, UUID> {
    @Override
    public Material cast(UUID dto) {
        return null;
    }

    @Override
    public UUID parse(Material entity) {
        return null;
    }

    @Override
    public Material cast() {
        return null;
    }
}
