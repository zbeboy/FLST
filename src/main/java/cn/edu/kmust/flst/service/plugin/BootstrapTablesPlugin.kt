package cn.edu.kmust.flst.service.plugin

import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.jooq.*
import org.springframework.util.ObjectUtils

/**
 * Created by zbeboy 2017-11-17 .
 **/
open class BootstrapTablesPlugin<T> {

    companion object {
        @JvmField
        val CONDITION_TYPE = 0

        @JvmField
        val JOIN_TYPE = 1

        @JvmField
        val ON_CONDITION_TYPE = 2
    }

    /**
     * 查询全部数据
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @param create          jooq create.
     * @param table           jooq table.
     * @return 全部数据
     */
    open fun dataPagingQueryAll(bootstrapTableUtils: BootstrapTableUtils<T>, create: DSLContext, table: TableLike<*>): Result<Record> {
        val a = searchCondition(bootstrapTableUtils)
        return if (ObjectUtils.isEmpty(a)) {
            val selectJoinStep = create.select()
                    .from(table)
            sortCondition(bootstrapTableUtils, null, selectJoinStep, JOIN_TYPE)
            pagination(bootstrapTableUtils, null, selectJoinStep, JOIN_TYPE)
            selectJoinStep.fetch()
        } else {
            val selectConditionStep = create.select()
                    .from(table)
                    .where(a)
            sortCondition(bootstrapTableUtils, selectConditionStep, null, CONDITION_TYPE)
            pagination(bootstrapTableUtils, selectConditionStep, null, CONDITION_TYPE)
            selectConditionStep.fetch()
        }
    }

    /**
     * 查询全部数据 with 额外条件
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @param create          jooq create.
     * @param table           jooq table.
     * @param extraCondition  额外条件
     * @return 全部数据
     */
    open fun dataPagingQueryAllWithCondition(bootstrapTableUtils: BootstrapTableUtils<T>, create: DSLContext, table: TableLike<*>, extraCondition: Condition): Result<Record> {
        val a = searchCondition(bootstrapTableUtils)
        return if (ObjectUtils.isEmpty(a)) {
            val selectConditionStep = create.select()
                    .from(table)
                    .where(extraCondition)
            sortCondition(bootstrapTableUtils, selectConditionStep, null, CONDITION_TYPE)
            pagination(bootstrapTableUtils, selectConditionStep, null, CONDITION_TYPE)
            selectConditionStep.fetch()
        } else {
            val selectConditionStep = create.select()
                    .from(table)
                    .where(extraCondition.and(a))
            sortCondition(bootstrapTableUtils, selectConditionStep, null, CONDITION_TYPE)
            pagination(bootstrapTableUtils, selectConditionStep, null, CONDITION_TYPE)
            selectConditionStep.fetch()
        }
    }

    /**
     * 查询全部数据 with 额外条件，无分页，做导出数据用
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @param create          jooq create.
     * @param table           jooq table.
     * @param extraCondition  额外条件
     * @return 全部数据
     */
    open fun dataPagingQueryAllWithConditionNoPage(bootstrapTableUtils: BootstrapTableUtils<T>, create: DSLContext, table: TableLike<*>, extraCondition: Condition): Result<Record> {
        val a = searchCondition(bootstrapTableUtils)
        return if (ObjectUtils.isEmpty(a)) {
            val selectConditionStep = create.select()
                    .from(table)
                    .where(extraCondition)
            selectConditionStep.fetch()
        } else {
            val selectConditionStep = create.select()
                    .from(table)
                    .where(extraCondition.and(a))
            selectConditionStep.fetch()
        }
    }

    /**
     * 统计全部
     *
     * @param create jooq create.
     * @param table  jooq table.
     * @return 统计
     */
    open fun statisticsAll(create: DSLContext, table: TableLike<*>): Int {
        return create.selectCount()
                .from(table)
                .fetchOne().value1()
    }

    /**
     * 统计全部 with 额外条件
     *
     * @param create         jooq create.
     * @param table          jooq table.
     * @param extraCondition 额外条件
     * @return 统计
     */
    open fun statisticsAllWithCondition(create: DSLContext, table: TableLike<*>, extraCondition: Condition): Int {
        return create.selectCount()
                .from(table)
                .where(extraCondition)
                .fetchOne().value1()
    }

    /**
     * 根据条件统计
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @param create          jooq create.
     * @param table           jooq table.
     * @return 统计
     */
    open fun statisticsWithCondition(bootstrapTableUtils: BootstrapTableUtils<T>, create: DSLContext, table: TableLike<*>): Int {
        val count: Record1<Int>
        val a = searchCondition(bootstrapTableUtils)
        count = if (ObjectUtils.isEmpty(a)) {
            val selectJoinStep = create.selectCount()
                    .from(table)
            selectJoinStep.fetchOne()
        } else {
            val selectConditionStep = create.selectCount()
                    .from(table)
                    .where(a)
            selectConditionStep.fetchOne()
        }
        return count.value1()
    }

    /**
     * 根据条件统计
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @param create          jooq create.
     * @param table           jooq table.
     * @param extraCondition  额外条件
     * @return 统计
     */
    open fun statisticsWithCondition(bootstrapTableUtils: BootstrapTableUtils<T>, create: DSLContext, table: TableLike<*>, extraCondition: Condition): Int {
        val count: Record1<Int>
        val a = searchCondition(bootstrapTableUtils)
        count = if (ObjectUtils.isEmpty(a)) {
            val selectConditionStep = create.selectCount()
                    .from(table)
                    .where(extraCondition)
            selectConditionStep.fetchOne()
        } else {
            val selectConditionStep = create.selectCount()
                    .from(table)
                    .where(extraCondition.and(a))
            selectConditionStep.fetchOne()
        }
        return count.value1()
    }

    /**
     * 查询条件，需要自行覆盖
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @return 查询条件
     */
    open fun searchCondition(bootstrapTableUtils: BootstrapTableUtils<T>): Condition? {
        return null
    }

    /**
     * 排序方式，需要自行覆盖
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @param selectConditionStep 条件1
     * @param selectJoinStep      条件2
     * @param type                类型
     */
    open fun sortCondition(bootstrapTableUtils: BootstrapTableUtils<T>, selectConditionStep: SelectConditionStep<Record>?, selectJoinStep: SelectJoinStep<Record>?, type: Int) {}

    /**
     * 排序辅助,调用此方法前请先调用cleanSortParam以避免对象污染所造成的排序混乱
     *
     * @param selectConditionStep 条件1
     * @param selectJoinStep      条件2
     * @param type                类型
     */
    open fun sortToFinish(selectConditionStep: SelectConditionStep<Record>?, selectJoinStep: SelectJoinStep<Record>?, type: Int, vararg sortField: SortField<*>?) {
        if (!ObjectUtils.isEmpty(sortField)) {
            if (type == CONDITION_TYPE) {
                selectConditionStep!!.orderBy(*sortField)
            }

            if (type == JOIN_TYPE) {
                selectJoinStep!!.orderBy(*sortField)
            }
        }
    }

    /**
     * 分页方式
     *
     * @param bootstrapTableUtils bootstrapTable工具类
     * @param selectConditionStep 条件1
     * @param selectJoinStep      条件2
     * @param type                类型
     */
    fun pagination(bootstrapTableUtils: BootstrapTableUtils<T>, selectConditionStep: SelectConditionStep<Record>?, selectJoinStep: SelectJoinStep<Record>?, type: Int) {
        val start = bootstrapTableUtils.pageNumber
        val length = bootstrapTableUtils.pageSize

        if (type == CONDITION_TYPE) {
            selectConditionStep!!.limit(start, length)
        }

        if (type == JOIN_TYPE) {
            selectJoinStep!!.limit(start, length)
        }
    }
}