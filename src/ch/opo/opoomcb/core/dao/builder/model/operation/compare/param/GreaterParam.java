package ch.opo.opoomcb.core.dao.builder.model.operation.compare.param;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.Param;

/**
 * @author Paweł Łabuda
 */
public class GreaterParam extends CompareColumnAndParam
{
   public GreaterParam(Column column, Param parameter)
   {
      super(column, parameter);
   }
}
