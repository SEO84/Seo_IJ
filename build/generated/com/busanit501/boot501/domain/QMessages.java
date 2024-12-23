package com.busanit501.boot501.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMessages is a Querydsl query type for Messages
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMessages extends EntityPathBase<Messages> {

    private static final long serialVersionUID = -220308183L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMessages messages = new QMessages("messages");

    public final StringPath content = createString("content");

    public final BooleanPath isRead = createBoolean("isRead");

    public final NumberPath<Integer> messageId = createNumber("messageId", Integer.class);

    public final QUsers receiver;

    public final QUsers sender;

    public final DateTimePath<java.time.LocalDateTime> sentAt = createDateTime("sentAt", java.time.LocalDateTime.class);

    public QMessages(String variable) {
        this(Messages.class, forVariable(variable), INITS);
    }

    public QMessages(Path<? extends Messages> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMessages(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMessages(PathMetadata metadata, PathInits inits) {
        this(Messages.class, metadata, inits);
    }

    public QMessages(Class<? extends Messages> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.receiver = inits.isInitialized("receiver") ? new QUsers(forProperty("receiver")) : null;
        this.sender = inits.isInitialized("sender") ? new QUsers(forProperty("sender")) : null;
    }

}

