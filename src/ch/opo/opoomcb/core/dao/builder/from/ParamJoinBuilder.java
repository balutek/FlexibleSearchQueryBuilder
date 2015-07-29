package ch.opo.opoomcb.core.dao.builder.from;

/**
 * @author Paweł Łabuda
 */
public class ParamJoinBuilder
{
    private JoinOnBuilder builder;

    public ParamJoinBuilder(StringBuilder headerQuery)
    {
        builder = new JoinOnBuilder(headerQuery, this);
    }

    public OperatorJoinBuilder isNull(String alias, String param)
    {
        builder.insertRestrictionWithNull(alias, param, "IS NULL");
        return builder.getOperatorJoinBuilder();
    }

    public OperatorJoinBuilder isNotNull(String alias, String param)
    {
        builder.insertRestrictionWithNull(alias, param, "IS NOT NULL");
        return builder.getOperatorJoinBuilder();
    }

    public OperatorJoinBuilder lesserThen(String alias1, String param1, String alias2, String param2)
    {
        builder.insertRestrictionWithOperator(alias1, param1, alias2, param2, "<");
        return builder.getOperatorJoinBuilder();
    }

    public OperatorJoinBuilder lesserOrEqualsThen(String alias1, String param1, String alias2, String param2)
    {
        builder.insertRestrictionWithOperator(alias1, param1, alias2, param2, "<=");
        return builder.getOperatorJoinBuilder();
    }

    public OperatorJoinBuilder greaterThen(String alias1, String param1, String alias2, String param2)
    {
        builder.insertRestrictionWithOperator(alias1, param1, alias2, param2, ">");
        return builder.getOperatorJoinBuilder();
    }

    public OperatorJoinBuilder greaterOrEqualsThen(String alias1, String param1, String alias2, String param2)
    {
        builder.insertRestrictionWithOperator(alias1, param1, alias2, param2, ">=");
        return builder.getOperatorJoinBuilder();
    }

//   public OperatorJoinBuilder startWith(String param, String value)
//   {
//      builder.insertRestrictionWithLike(param, value + "%");
//      return builder.getOperatorJoinBuilder();
//   }
//
//   public OperatorJoinBuilder endWith(String param, String value)
//   {
//      builder.insertRestrictionWithLike(param, "%" + value);
//      return builder.getOperatorJoinBuilder();
//   }
//
//   public OperatorJoinBuilder contains(String param, String value)
//   {
//      builder.insertRestrictionWithLike(param, "%" + value + "%");
//      return builder.getOperatorJoinBuilder();
//   }
//
//   public OperatorJoinBuilder like(String param, String value)
//   {
//      builder.insertRestrictionWithLike(param, value);
//      return builder.getOperatorJoinBuilder();
//   }

    public OperatorJoinBuilder equals(String alias1, String param1, String alias2, String param2)
    {
        builder.insertRestrictionWithOperator(alias1, param1, alias2, param2, "=");
        return builder.getOperatorJoinBuilder();
    }

    public OperatorJoinBuilder notEquals(String alias1, String param1, String alias2, String param2)
    {
        builder.insertRestrictionWithOperator(alias1, param1, alias2, param2, "<>");
        return builder.getOperatorJoinBuilder();
    }

//   public OperatorJoinBuilder isIn(String param, Object... values)
//   {
//      builder.insertRestrictionIn(param, values);
//      return builder.getOperatorJoinBuilder();
//   }
//
//   public OperatorJoinBuilder isIn(String param, Collection values)
//   {
//      builder.insertRestrictionIn(param, values);
//      return builder.getOperatorJoinBuilder();
//   }

    public ParamJoinBuilder openBracket()
    {
        builder.openBracket();
        return builder.getParamJoinBuilder();
    }
}
