/*
 * This file is generated by jOOQ.
*/
package cn.edu.kmust.flst.domain;


import cn.edu.kmust.flst.domain.information_schema.InformationSchema;
import cn.edu.kmust.flst.domain.public_.Public;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultCatalog extends CatalogImpl {

    private static final long serialVersionUID = -982560521;

    /**
     * The reference instance of <code></code>
     */
    public static final DefaultCatalog DEFAULT_CATALOG = new DefaultCatalog();

    /**
     * The schema <code>information_schema</code>.
     */
    public final InformationSchema INFORMATION_SCHEMA = cn.edu.kmust.flst.domain.information_schema.InformationSchema.INFORMATION_SCHEMA;

    /**
     * The schema <code>public</code>.
     */
    public final Public PUBLIC = cn.edu.kmust.flst.domain.public_.Public.PUBLIC;

    /**
     * No further instances allowed
     */
    private DefaultCatalog() {
        super("");
    }

    @Override
    public final List<Schema> getSchemas() {
        List result = new ArrayList();
        result.addAll(getSchemas0());
        return result;
    }

    private final List<Schema> getSchemas0() {
        return Arrays.<Schema>asList(
            InformationSchema.INFORMATION_SCHEMA,
            Public.PUBLIC);
    }
}
