public class Bus extends Transportation{
    private int fare = 1000; // 요금
    private int currentPax;

    public Bus(int num) {
        super(num);
        this.setMaxPassenger(30);
    }

    @Override
    public void start() {
        if(checkGas() < 10 && checkGas() >= 0){ //주유량이 10이상일 때만 운행가능, alert!
            System.out.println("주유량 = "+ this.checkGas());
            System.out.println("'주유 필요'");
        } else super.start();
    }

    @Override
    public void finish() {
        super.finish();
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    @Override
    public void changeStatus() {
        super.changeStatus();
    }

    @Override
    public void takePax(int passenger) {
        if(this.getStatus().equals("운행중")) {
            super.takePax(passenger);

            if (this.getPassenger() <= this.getMaxPassenger()) {
                System.out.println("요금 확인 = " + getTotalMoney());
            } else {
                this.setPassenger(passenger);
            }
        } else {
            System.out.println("현재 운행중인 상태가 아닙니다.");
        }
    }

    @Override
    public int getPassenger() {
        return this.currentPax;
    }

    @Override
    public void setPassenger(int passenger) {
        this.currentPax += passenger;
    }

    @Override
    public void takeGas(int gas) {
        super.takeGas(gas);

        if(gas < 0) {
            if( this.checkGas() >= 10 ) {
                System.out.println("주유량 = " + this.checkGas());
            } else {
                if(this.getStatus().equals("운행중")) setStatus("차고지행");

                System.out.println("주유량 = " + this.checkGas() +
                        "\n상태 = " + this.getStatus() +
                        "\n'주유 필요'");
            }
        } else {
            if(this.getStatus().equals("운행중")) changeStatus();
            System.out.println("상태 = " + getStatus() +
                    "\n주유량 = " + checkGas());
        }
    }

    @Override
    public void setChangeSpeed(int speed) {
        if(this.getStatus().equals("운행중") && checkGas() >= 10) {
            super.setChangeSpeed(speed);
        } else {
            if(!this.getStatus().equals("운행중")) {
                System.out.println("현재 운행중인 상태가 아닙니다.");
            }
        }
    }

    @Override
    public int getCurrentSpeed() {
        return super.getCurrentSpeed();
    }


    public int getTotalMoney() {
        return this.getPassenger() * this.fare;
    }

    @Override
    public String toString() {
        return "Bus 번호 = " + this.getNum();
    }
}