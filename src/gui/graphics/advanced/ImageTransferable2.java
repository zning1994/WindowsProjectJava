package gui.graphics.advanced;
import java.awt.*;
import java.awt.datatransfer.*;

/**
 * This class is a wrapper for the data transfer of image objects.
 */
public class ImageTransferable2 implements Transferable
{
   /**
    * Constructs the selection.
    * @param image an image
    */
   public ImageTransferable2(Image image)
   {
      theImage = image;
   }

   public DataFlavor[] getTransferDataFlavors()
   {
      return new DataFlavor[] { DataFlavor.imageFlavor };
   }

   public boolean isDataFlavorSupported(DataFlavor flavor)
   {
      return flavor.equals(DataFlavor.imageFlavor);
   }

   public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException
   {
      if (flavor.equals(DataFlavor.imageFlavor))
      {
         return theImage;
      }
      else
      {
         throw new UnsupportedFlavorException(flavor);
      }
   }

   private Image theImage;
}
