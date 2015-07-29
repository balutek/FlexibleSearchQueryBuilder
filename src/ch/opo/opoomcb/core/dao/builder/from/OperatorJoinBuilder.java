package ch.opo.opoomcb.core.dao.builder.from;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;
import ch.opo.opoomcb.core.dao.builder.whereSegment.ParamBuilder;

/**
 * @author Paweł Łabuda
 */
public class OperatorJoinBuilder
{
    private JoinOnBuilder builder;

    public OperatorJoinBuilder(JoinOnBuilder builder)
    {
        this.builder = builder;
    }

//   public String build()
//   {
//      return builder.build();
//   }

//   public OrderBySegmentBuilder orderBy(String order)
//   {
//      return builder.getOrderByBuilder(order);
//   }

    public ParamBuilder where()
    {
        builder.closeJoinBuilder();
        return builder.getParamBuilder();
    }

    public ParamJoinBuilder and()
    {
        builder.insertOperator(QueryElements.AND);
        return builder.getParamJoinBuilder();
    }

    public ParamJoinBuilder or()
    {
        builder.insertOperator(QueryElements.OR);
        return builder.getParamJoinBuilder();
    }

    public OperatorJoinBuilder closeBracket()
    {
        builder.closeBracket();
        return builder.getOperatorJoinBuilder();
    }
}