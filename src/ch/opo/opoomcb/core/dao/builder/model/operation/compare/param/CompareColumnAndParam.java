package ch.opo.opoomcb.core.dao.builder.model.operation.compare.param;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.Param;
import ch.opo.opoomcb.core.dao.builder.model.operation.compare.CompareOperation;

/**
 * @author Paweł Łabuda
 */
public abstract class CompareColumnAndParam extends CompareOperation
{
   private Column column;

   private Param parameter;

   public CompareColumnAndParam(Column column, Param parameter)
   {
      this.column = column;
      this.parameter = parameter;
   }

   public Column getColumn()
   {
      return column;
   }

   public Param getParameter()
   {
      return parameter;
   }
}
