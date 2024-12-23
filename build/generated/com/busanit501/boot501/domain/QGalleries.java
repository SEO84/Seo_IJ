package com.busanit501.boot501.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGalleries is a Querydsl query type for Galleries
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGalleries extends EntityPathBase<Galleries> {

    private static final long serialVersionUID = -775038157L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGalleries galleries = new QGalleries("galleries");

    public final NumberPath<Integer> galleryId = createNumber("galleryId", Integer.class);

    public final EnumPath<Galleries.MediaType> mediaType = createEnum("mediaType", Galleries.MediaType.class);

    public final StringPath mediaUrl = createString("mediaUrl");

    public final DateTimePath<java.time.LocalDateTime> uploadedAt = createDateTime("uploadedAt", java.time.LocalDateTime.class);

    public final QUsers user;

    public QGalleries(String variable) {
        this(Galleries.class, forVariable(variable), INITS);
    }

    public QGalleries(Path<? extends Galleries> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGalleries(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGalleries(PathMetadata metadata, PathInits inits) {
        this(Galleries.class, metadata, inits);
    }

    public QGalleries(Class<? extends Galleries> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user")) : null;
    }

}

