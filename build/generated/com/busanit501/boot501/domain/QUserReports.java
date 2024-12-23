package com.busanit501.boot501.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserReports is a Querydsl query type for UserReports
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserReports extends EntityPathBase<UserReports> {

    private static final long serialVersionUID = 1173974647L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserReports userReports = new QUserReports("userReports");

    public final StringPath reason = createString("reason");

    public final QUsers reported;

    public final DateTimePath<java.time.LocalDateTime> reportedAt = createDateTime("reportedAt", java.time.LocalDateTime.class);

    public final QUsers reporter;

    public final NumberPath<Integer> reportId = createNumber("reportId", Integer.class);

    public final EnumPath<UserReports.ReportStatus> status = createEnum("status", UserReports.ReportStatus.class);

    public QUserReports(String variable) {
        this(UserReports.class, forVariable(variable), INITS);
    }

    public QUserReports(Path<? extends UserReports> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserReports(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserReports(PathMetadata metadata, PathInits inits) {
        this(UserReports.class, metadata, inits);
    }

    public QUserReports(Class<? extends UserReports> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reported = inits.isInitialized("reported") ? new QUsers(forProperty("reported")) : null;
        this.reporter = inits.isInitialized("reporter") ? new QUsers(forProperty("reporter")) : null;
    }

}

