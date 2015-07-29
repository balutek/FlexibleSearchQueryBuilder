package ch.opo.opoomcb.core.dao.builder.from;

import ch.opo.opoomcb.core.dao.builder.constants.QueryElements;
import ch.opo.opoomcb.core.dao.builder.whereSegment.ParamBuilder;

/**
 * @author Paweł Łabuda
 */
public class JoinOnBuilder
{
    private StringBuilder query;

    private ParamJoinBuilder paramJoinBuilder;

    private OperatorJoinBuilder operatorJoinBuilder;

    private int bracketCount = 0;

    public JoinOnBuilder(StringBuilder query, ParamJoinBuilder paramJoinBuilder)
    {
        this.query = query
                .append(QueryElements.ON)
                .append(QueryElements.OPEN_BRACKET);
        this.paramJoinBuilder = paramJoinBuilder;
        this.operatorJoinBuilder = new OperatorJoinBuilder(this);
    }

    public void insertRestrictionWithOperator(String alias1, String param1, String alias2, String param2, String operator)
    {
        query.append(QueryElements.KEY_PARAM_PREFIX)
                .append(alias1)
                .append(".")
                .append(param1)
                .append(QueryElements.KEY_PARAM_SUFFIX)
                .append(" ")
                .append(operator)
                .append(" ")
                .append(QueryElements.KEY_PARAM_PREFIX)
                .append(alias2)
                .append(".")
                .append(param2)
                .append(QueryElements.KEY_PARAM_SUFFIX);
    }

    public void insertRestrictionWithNull(String alias, String param, String nullQuery)
    {
        query.append(QueryElements.KEY_PARAM_PREFIX)
                .append(alias)
                .append(".")
                .append(param)
                .append(QueryElements.KEY_PARAM_SUFFIX)
                .append(" ")
                .append(nullQuery);
    }

    public void insertOperator(QueryElements element)
    {
        query.append(element);
    }

    public void openBracket()
    {
        bracketCount++;
        query.append(QueryElements.OPEN_BRACKET);
    }

    public void closeBracket()
    {
        bracketCount--;
        if (bracketCount < 0)
        {
            bracketCount = 0;
        }
        else
        {
            query.append(QueryElements.CLOSE_BRACKET);
        }
    }

    public void closeJoinBuilder()
    {
        query.append(QueryElements.CLOSE_BRACKET);
    }

    public ParamJoinBuilder getParamJoinBuilder()
    {
        return paramJoinBuilder;
    }

    public OperatorJoinBuilder getOperatorJoinBuilder()
    {
        return operatorJoinBuilder;
    }

    public ParamBuilder getParamBuilder()
    {
        return new ParamBuilder(query);
    }
}