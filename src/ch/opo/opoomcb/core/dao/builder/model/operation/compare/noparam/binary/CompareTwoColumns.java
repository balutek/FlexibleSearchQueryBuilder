package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.binary;

import ch.opo.opoomcb.core.dao.builder.model.Column;
import ch.opo.opoomcb.core.dao.builder.model.operation.compare.CompareOperation;

/**
 * @author Paweł Łabuda
 */
public abstract class CompareTwoColumns extends CompareOperation
{
   private Column firstColumn;

   private Column secondColumn;

   public CompareTwoColumns(Column firstColumn, Column secondColumn)
   {
      super();

      this.firstColumn = firstColumn;
      this.secondColumn = secondColumn;
   }

   public Column getFirstColumn()
   {
      return firstColumn;
   }

   public Column getSecondColumn()
   {
      return secondColumn;
   }
}
