package smecalculus.bezmen.storage.mybatis;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import smecalculus.bezmen.storage.SepulkaEdge;

public interface SepulkaSqlMapper {

    @Insert(
            """
                INSERT INTO sepulkas (
                    internal_id,
                    external_id,
                    version
                )
                VALUES (
                    #{internalId},
                    #{externalId},
                    #{version}
                )
            """)
    void insert(SepulkaEdge sepulkaEdge);

    @Select(
            """
                 SELECT
                     internal_id as internalId,
                     external_id as externalId,
                     version
                 FROM sepulkas
                 WHERE internal_id = #{internalId}
            """)
    Optional<SepulkaEdge> findById(String internalId);

    @Select("SELECT * FROM sepulkas")
    List<SepulkaEdge> selectAll();
}
