package com.busanit501.boot501.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWalkSchedules is a Querydsl query type for WalkSchedules
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWalkSchedules extends EntityPathBase<WalkSchedules> {

    private static final long serialVersionUID = 1872348982L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWalkSchedules walkSchedules = new QWalkSchedules("walkSchedules");

    public final NumberPath<Integer> scheduleId = createNumber("scheduleId", Integer.class);

    public final EnumPath<WalkSchedules.WalkStatus> status = createEnum("status", WalkSchedules.WalkStatus.class);

    public final QUsers user;

    public final DatePath<java.time.LocalDate> walkDate = createDate("walkDate", java.time.LocalDate.class);

    public final TimePath<java.time.LocalTime> walkTime = createTime("walkTime", java.time.LocalTime.class);

    public QWalkSchedules(String variable) {
        this(WalkSchedules.class, forVariable(variable), INITS);
    }

    public QWalkSchedules(Path<? extends WalkSchedules> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWalkSchedules(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWalkSchedules(PathMetadata metadata, PathInits inits) {
        this(WalkSchedules.class, metadata, inits);
    }

    public QWalkSchedules(Class<? extends WalkSchedules> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user")) : null;
    }

}

