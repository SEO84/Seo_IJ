package com.busanit501.boot501.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPets is a Querydsl query type for Pets
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPets extends EntityPathBase<Pets> {

    private static final long serialVersionUID = -206027375L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPets pets = new QPets("pets");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final EnumPath<Pets.Gender> gender = createEnum("gender", Pets.Gender.class);

    public final StringPath name = createString("name");

    public final StringPath personality = createString("personality");

    public final NumberPath<Integer> petId = createNumber("petId", Integer.class);

    public final StringPath profilePicture = createString("profilePicture");

    public final StringPath type = createString("type");

    public final QUsers user;

    public final NumberPath<Float> weight = createNumber("weight", Float.class);

    public QPets(String variable) {
        this(Pets.class, forVariable(variable), INITS);
    }

    public QPets(Path<? extends Pets> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPets(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPets(PathMetadata metadata, PathInits inits) {
        this(Pets.class, metadata, inits);
    }

    public QPets(Class<? extends Pets> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUsers(forProperty("user")) : null;
    }

}

