package com.busanit501.boot501.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWalkRecords is a Querydsl query type for WalkRecords
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWalkRecords extends EntityPathBase<WalkRecords> {

    private static final long serialVersionUID = 2023258940L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWalkRecords walkRecords = new QWalkRecords("walkRecords");

    public final NumberPath<Integer> duration = createNumber("duration", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> endTime = createDateTime("endTime", java.time.LocalDateTime.class);

    public final NumberPath<Integer> recordId = createNumber("recordId", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> startTime = createDateTime("startTime", java.time.LocalDateTime.class);

    public final QUsers user;

    public QWalkRecords(String variable) {
        this(WalkRecords.class, forVariable(variable), INITS);
    }

    public QWalkRecords(Path<? extends WalkRecords> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWalkRecords(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWalkRecords(PathMetadata metadata, PathInits inits) {
        this(WalkRecords.class, metadata, inits);
    }

    public QWalkRecords(Class<? extends WalkRecords> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user")) : null;
    }

}

