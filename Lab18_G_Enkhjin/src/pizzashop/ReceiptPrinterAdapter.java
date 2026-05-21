package pizzashop;

// Хуучин систем — өөрчилж болохгүй
class LegacyPrinter {
    public void printRaw(byte[] data) {
        System.out.write(data, 0, data.length);
        System.out.println();
    }
}

// Шинэ интерфейс
interface Printer {
    void print(String text);
}

// Adapter — LegacyPrinter-ийг Printer болгон хувиргана
public class ReceiptPrinterAdapter implements Printer {
    private LegacyPrinter legacyPrinter;

    public ReceiptPrinterAdapter() {
        this.legacyPrinter = new LegacyPrinter();
    }

    public void print(String text) {
        // String-ийг byte[] болгож хуучин хэвлэгчид дамжуулна
        byte[] data = text.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        legacyPrinter.printRaw(data);
    }
}
