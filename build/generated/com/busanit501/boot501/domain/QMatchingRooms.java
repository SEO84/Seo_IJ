package com.busanit501.boot501.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMatchingRooms is a Querydsl query type for MatchingRooms
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMatchingRooms extends EntityPathBase<MatchingRooms> {

    private static final long serialVersionUID = -66553026L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMatchingRooms matchingRooms = new QMatchingRooms("matchingRooms");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> currentParticipants = createNumber("currentParticipants", Integer.class);

    public final StringPath description = createString("description");

    public final QUsers host;

    public final NumberPath<Integer> maxParticipants = createNumber("maxParticipants", Integer.class);

    public final NumberPath<Integer> roomId = createNumber("roomId", Integer.class);

    public final EnumPath<MatchingRooms.RoomStatus> status = createEnum("status", MatchingRooms.RoomStatus.class);

    public final StringPath title = createString("title");

    public QMatchingRooms(String variable) {
        this(MatchingRooms.class, forVariable(variable), INITS);
    }

    public QMatchingRooms(Path<? extends MatchingRooms> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMatchingRooms(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMatchingRooms(PathMetadata metadata, PathInits inits) {
        this(MatchingRooms.class, metadata, inits);
    }

    public QMatchingRooms(Class<? extends MatchingRooms> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.host = inits.isInitialized("host") ? new QUsers(forProperty("host")) : null;
    }

}

