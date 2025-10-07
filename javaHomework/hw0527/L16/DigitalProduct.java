package javaHomework.hw0527.L16;

public class DigitalProduct extends Product {
    private int downloadLimit;
    private int downloadCount;

    public DigitalProduct(String id, String name, int price, int stock, int downloadLimit) {
        super(id, name, price, stock);
        setDownloadLimit(downloadLimit);
        this.downloadCount = 0;
    }

    public void setDownloadLimit(int limit) {
        this.downloadLimit = limit;
    }

    public int getDownloadLimit() {
        return downloadLimit;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void download() {
        if (downloadCount < downloadLimit) {
            downloadCount++;
            System.out.println(getName() + " 下載成功，第 " + downloadCount + "/" + downloadLimit + " 次");
        } else {
            System.out.println(getName() + " 已達到下載次數限制");
        }
    }
}
