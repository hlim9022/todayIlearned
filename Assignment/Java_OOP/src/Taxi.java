public class Taxi extends Transportation{
    private String type; // 타입
    private int baseDistance; // 기본거리
    private int baseFare; // 기본요금
    private int fareByDist; // 거리당 요금
    private int totalMoney; // 누적금액

    public Taxi(int num) {
        super(num);
        this.setMaxPassenger(4);
        this.type = "일반";
        this.baseFare = 3000;
        this.fareByDist = 1000;
        this.baseDistance = 1;
    }

    @Override
    public void start() {
        if(checkGas() < 10 && checkGas() >= 0) {
            this.setStatus("운행불가");
            System.out.println("주유량 = "+ this.checkGas());
            System.out.println("'주유 필요'");
        } else {
            super.start();
        }

    }

    @Override
    public void finish() {
        this.setStatus("운행종료");
    }

    @Override
    public void takePax(int passenger) {
        if(getType().equals("일반")) {
            super.takePax(passenger);
            setStatus("운행중");
            setType("탑승불가");

            if(this.getPassenger() > this.getMaxPassenger()) { // 탑승자수가 최대 탑승가능 승객을 초과시
                this.setPassenger(0); // 탑승할 수 없으니 승객수를 0으로 초기화
            }
        } else {
            System.out.println("현재 탑승이 불가합니다.");
        }
    }

    @Override
    public void changeStatus() {
        if (this.checkGas() == 0) { // 주유량이 0일 때만, 운행불가로 상태변경!
            this.setStatus("운행불가");
        } else if(this.checkGas() > 0) this.setStatus("운행중");
    }

    public void driveInfo(String destination, int distance) {
        setTotalMoney(payTotal(distance));
        if(this.getPassenger() <= this.getMaxPassenger()) {
            System.out.println("기본 요금 확인 = " + this.baseFare +
                    "\n목적지 = " + destination +
                    "\n목적지까지 거리 = " + distance + "km" +
                    "\n지불할 요금 = " + payTotal(distance));
        }
    }

    public int payTotal(int distance) {
        return this.baseFare + ((distance - getBaseDistance()) * this.fareByDist);
    }

    public int getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney += totalMoney;
    }

    public void makePayment(int gas) { // 운행 완료 후 결제
        takeGas(gas);
        System.out.println("누적 요금 = " + getTotalMoney());
        this.setPassenger(0); // 승객 하차
        setType("일반"); // 승객 탑승할 수 있도록 타입 변경
    }

    @Override
    public void takeGas(int gas) {
        super.takeGas(gas);

        start();
    }

    @Override
    public String toString() {
        return "Taxi 번호: " + this.getNum() +
                "\n주유량 = " + this.checkGas() +
                "\n상태 = " + this.type;
    }

    public int getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(int baseFare) {
        this.baseFare = baseFare;
    }

    public int getFareByDist() {
        return fareByDist;
    }

    public void setFareByDist(int fareByDist) {
        this.fareByDist = fareByDist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBaseDistance() {
        return baseDistance;
    }

    public void setBaseDistance(int baseDistance) {
        this.baseDistance = baseDistance;
    }
}
