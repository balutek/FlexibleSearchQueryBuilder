package ch.opo.opoomcb.core.dao.builder.from;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;
import ch.opo.opoomcb.core.dao.builder.model.operation.bitwise.And;
import ch.opo.opoomcb.core.dao.builder.model.operation.bitwise.Or;
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
        return builder.getParamBuilder();
    }

    public ParamJoinBuilder and()
    {
        builder.insertOperation(new And());
        return builder.getParamJoinBuilder();
    }

    public ParamJoinBuilder or()
    {
        builder.insertOperation(new Or());
        return builder.getParamJoinBuilder();
    }

    public OperatorJoinBuilder closeBracket()
    {
        builder.closeBracket();
        return builder.getOperatorJoinBuilder();
    }
}