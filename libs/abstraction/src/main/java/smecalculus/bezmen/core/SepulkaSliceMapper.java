package smecalculus.bezmen.core;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.ClientSide.RegistrationRequest;
import smecalculus.bezmen.core.ClientSide.RegistrationResponse;
import smecalculus.bezmen.core.ServerSide.StorageState;

@Mapper
public interface SepulkaSliceMapper {
    StorageState.Builder toServer(RegistrationRequest request);

    RegistrationResponse.Builder toClient(StorageState state);
}
