package com.busanit501.boot501.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoomParticipants is a Querydsl query type for RoomParticipants
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomParticipants extends EntityPathBase<RoomParticipants> {

    private static final long serialVersionUID = 1640598264L;

    public static final QRoomParticipants roomParticipants = new QRoomParticipants("roomParticipants");

    public final DateTimePath<java.time.LocalDateTime> joinedAt = createDateTime("joinedAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> roomId = createNumber("roomId", Integer.class);

    public final EnumPath<RoomParticipants.ParticipantStatus> status = createEnum("status", RoomParticipants.ParticipantStatus.class);

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public QRoomParticipants(String variable) {
        super(RoomParticipants.class, forVariable(variable));
    }

    public QRoomParticipants(Path<? extends RoomParticipants> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoomParticipants(PathMetadata metadata) {
        super(RoomParticipants.class, metadata);
    }

}

