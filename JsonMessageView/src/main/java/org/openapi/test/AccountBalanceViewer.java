package org.openapi.test;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.openapi.balance.*;
import org.openapi.common.AccInfo;
import org.openapi.common.CommonHeader;
import org.openapi.transaction.QueryResult;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by heungjae on 2016-07-07.
 */
public class AccountBalanceViewer {

    public static void main(String[] args) {

        String jsonMsg = "{\"commonHeader\":{\"reqIdPlatform\":\"test1\",\"reqIdConsumer\":\"string\",\"certDn\":\"cn\\u003d홍길동-13491629,ou\\u003dHTS,ou\\u003dNH투자,ou\\u003d증권,o\\u003dSignKorea,c\\u003dKR\",\"ci\":\"S1V7HGXBV1EPGBJasoZf4fQV+eOpOc1pfizByV6UIEYJHM/PF9QKu+PU2OThEog7QmVKSZNibNGg+/k0XB/9jQ\\u003d\\u003d\"},\"balanceResponseBody\":{\"accInfo\":{\"vtAccNo\":\"160678007213500001\"},\"queryType\":{\"assetType\":\"FUND\",\"count\":\"0\",\"page\":\"null\"},\"queryResult\":{\"totalCnt\":7.0,\"count\":7.0,\"page\":\"null\"}},\"balanceList\":{\"balance\":[{\"summary\":{\"cashBalance\":6976542.0,\"d1\":6976542.0,\"d2\":6976542.0,\"substitute\":9.816358E7,\"receivable\":0.0,\"subsMargin\":762635.0,\"loanCredit\":0.0,\"valAtTrade\":3.69827563509E11,\"valueAtCur\":3.89165309112E11,\"proLoss\":1.9337745603E10,\"totalAccVal\":3.89172285654E11,\"cashAvWithdraw\":6976542.0}},{\"fundList\":[{\"fundCode\":\"KRZ500395135\",\"fundName\":\"삼성중소형FOCUS증권자1호[주식]\",\"valAtTrade\":0.0,\"valAtCur\":7.2329965E7,\"proLoss\":7.2329965E7,\"firstDateBuy\":\"20160112\",\"lastDateBuy\":\"20160113\",\"maturity\":\"00000000\",\"earningRate\":-9.58},{\"fundCode\":\"KRZ500395136\",\"fundName\":\"삼성중소형FOCUS증권자1호[주식]\",\"valAtTrade\":0.0,\"valAtCur\":8747937.0,\"proLoss\":8747937.0,\"firstDateBuy\":\"20150820\",\"lastDateBuy\":\"20150910\",\"maturity\":\"00000000\",\"earningRate\":-12.52},{\"fundCode\":\"KRZ501130561\",\"fundName\":\"미래에셋고배당포커스증권자1호(\",\"valAtTrade\":0.0,\"valAtCur\":9274843.0,\"proLoss\":9274843.0,\"firstDateBuy\":\"20150804\",\"lastDateBuy\":\"20150921\",\"maturity\":\"00000000\",\"earningRate\":-6.32},{\"fundCode\":\"KRZ501151101\",\"fundName\":\"동양중소형고배당증권자1호(주식\",\"valAtTrade\":0.0,\"valAtCur\":8876142.0,\"proLoss\":8876142.0,\"firstDateBuy\":\"20150818\",\"lastDateBuy\":\"20150819\",\"maturity\":\"00000000\",\"earningRate\":-10.35},{\"fundCode\":\"KRZ501798293\",\"fundName\":\"미래에셋한국헬스케어증권자1호(\",\"valAtTrade\":0.0,\"valAtCur\":1.9147965E7,\"proLoss\":1.9147965E7,\"firstDateBuy\":\"20150824\",\"lastDateBuy\":\"20160201\",\"maturity\":\"00000000\",\"earningRate\":-4.26},{\"fundCode\":\"KRZ501798297\",\"fundName\":\"미래에셋한국헬스케어증권자1호(\",\"valAtTrade\":0.0,\"valAtCur\":2.8851314E7,\"proLoss\":2.8851314E7,\"firstDateBuy\":\"20150819\",\"lastDateBuy\":\"20160201\",\"maturity\":\"00000000\",\"earningRate\":-3.82},{\"fundCode\":\"KRZ501831185\",\"fundName\":\"메리츠코리아증권투자신탁1호[주\",\"valAtTrade\":0.0,\"valAtCur\":8416030.0,\"proLoss\":8416030.0,\"firstDateBuy\":\"20150818\",\"lastDateBuy\":\"20150819\",\"maturity\":\"00000000\",\"earningRate\":-15.83}]}]},\"resp\":{\"respCode\":\"200\",\"respMsg\":\"OK\"}}\n";

        Gson gson = new Gson();
        BalanceResponse balanceResponse = gson.fromJson(jsonMsg, BalanceResponse.class);

        CommonHeader commonHeader = balanceResponse.getCommonHeader();
        System.out.println("-------------------------------------");
        System.out.println("DN = "+ commonHeader.getCertDn());

        BalanceResponseBody balanceResponseBody = balanceResponse.getBalanceResponseBody();
        AccInfo accInfo  = balanceResponseBody.getAccInfo();

        System.out.println("실계좌번호 = "+accInfo.getRealAccNo());
        System.out.println("가상계좌번호 = "+accInfo.getVtAccNp());

        QueryResult queryResult = balanceResponseBody.getQueryResult();
        System.out.println("-------------------------------------");
        System.out.println("조회결과:총건수= "+queryResult.getTotalCnt());
        System.out.println("조회결과:금번건수= "+queryResult.getCount());
        if (queryResult.getPage() == null || queryResult.getPage().equals("null") ) {
            System.out.println("더이상 조회할 페이지가 없습니다.");
        }else {
            System.out.println("다음 페이지의 키 = ["+queryResult.getPage()+"]");
        }
        BalanceList balanceList = balanceResponse.getBalanceList();

        JsonParser parser = new JsonParser();
        JsonObject data = parser.parse(jsonMsg).getAsJsonObject().getAsJsonObject("balanceList");
        JsonArray array = data.getAsJsonArray("balance");
        int equityCnt =0, fundCnt =0, etcCnt = 0;
        for (JsonElement je1 : array) {
            if (je1.getAsJsonObject().get("summary") != null) {
                BalanceSummary balanceSummary = gson.fromJson(je1.getAsJsonObject().get("summary"), BalanceSummary.class);
                System.out.println("-------------------------------------");
                System.out.println("계좌내현금 - ["+new BigDecimal(balanceSummary.getCashBalance())+"]");
                System.out.println("d+1현금 - ["+new BigDecimal(balanceSummary.getD1())+"]");
                System.out.println("d+2현금 - ["+new BigDecimal(balanceSummary.getD2())+"]");
                System.out.println("대용금 - ["+new BigDecimal(balanceSummary.getSubstiture())+"]");
                System.out.println("미수/미납금 - ["+new BigDecimal(balanceSummary.getReceivable())+"]");
                System.out.println("대용증거금 - ["+new BigDecimal(balanceSummary.getSubsMargin())+"]");
                System.out.println("대출/신용금 - ["+new BigDecimal(balanceSummary.getLoanCredit())+"]");
                System.out.println("유가증권매수금액 - ["+new BigDecimal(balanceSummary.getValAtTrade())+"]");
                System.out.println("유가증권평가금액 - ["+new BigDecimal(balanceSummary.getValueAtCur())+"]");
                System.out.println("유가증권평가손익 - ["+new BigDecimal(balanceSummary.getProLoss())+"]");
                System.out.println("총평가금액 - ["+new BigDecimal(balanceSummary.getTotalAccVal())+"]");
                System.out.println("출금가능액 - ["+new BigDecimal(balanceSummary.getCashAvWithdraw())+"]");
            } else if (je1.getAsJsonObject().get("equityList") !=null) {
                Type listType = new TypeToken<ArrayList<EquityBalance>>(){}.getType();
                ArrayList arrayList = gson.fromJson(je1.getAsJsonObject().get("equityList"), listType);
                System.out.println("-------------------------------------");
                equityCnt = arrayList.size();
                System.out.println("Equity 상품군 종목수 = ["+equityCnt+"]");
                for(Object object : arrayList) {
                    EquityBalance equityBalance = (EquityBalance)object;
                    System.out.println("-------------------------------------");
                    System.out.println("상품구분 - [" + equityBalance.getAssetType() +"]");
                    System.out.println("종목코드 - [" + equityBalance.getIsinCode()+"]");
                    System.out.println("보유수량 - [" + equityBalance.getQty()+"]");
                    System.out.println("거래유형 - ["+ equityBalance.getTradeType()+"]");
                    System.out.println("매수금액 - ["+ new BigDecimal(equityBalance.getValAtTrade())+"]");
                    System.out.println("평가금액 - ["+ new BigDecimal(equityBalance.getValAtCur())+"]");
                    System.out.println("평가손익 - ["+ new BigDecimal(equityBalance.getProLoss())+"]");
                    System.out.println("수익률 - [" + equityBalance.getEarningRate()+"%]");
                }
            } else if (je1.getAsJsonObject().get("fundList") !=null) {
                Type listType = new TypeToken<ArrayList<FundBalance>>(){}.getType();
                ArrayList arrayList = gson.fromJson(je1.getAsJsonObject().get("fundList"), listType);
                System.out.println("-------------------------------------");
                fundCnt = arrayList.size();
                System.out.println("fundList 상품군 종목수 = ["+fundCnt+"]");
                for(Object object : arrayList) {
                    FundBalance fundBalance = (FundBalance)object;
                    System.out.println("-------------------------------------");
                    System.out.println("펀드코드 - [" + fundBalance.getFundCode() +"]");
                    System.out.println("펀드이름 - [" + fundBalance.getFundName()+"]");
                    System.out.println("매수금액 - ["+ new BigDecimal(fundBalance.getValAtTrade())+"]");
                    System.out.println("평가금액 - ["+ new BigDecimal(fundBalance.getValAtCur())+"]");
                    System.out.println("평가손익 - ["+ new BigDecimal(fundBalance.getProLoss())+"]");
                    System.out.println("최초매수일 - ["+ fundBalance.getFirstDateBuy()+"]");
                    System.out.println("최종매수일 - ["+ fundBalance.getLastDateBuy()+"]");
                    System.out.println("만기일 - [" + fundBalance.getMaturity()+"]");
                    System.out.println("수익률 - [" + fundBalance.getEarningRate()+"%]");
                }
            } else if (je1.getAsJsonObject().get("etcList") !=null) {
                Type listType = new TypeToken<ArrayList<EtcBalance>>(){}.getType();
                ArrayList arrayList = gson.fromJson(je1.getAsJsonObject().get("etcList"), listType);
                System.out.println("-------------------------------------");
                etcCnt = arrayList.size();
                System.out.println("etcList 상품군 종목수 = ["+etcCnt+"]");
                for(Object object : arrayList) {
                    EtcBalance etcBalance = (EtcBalance)object;
                    System.out.println("-------------------------------------");
                    System.out.println("상품구분 - [" + etcBalance.getAssetType() +"]");
                    System.out.println("상품이름 - [" + etcBalance.getAssetName()+"]");
                    System.out.println("보유수량 - [" + new BigDecimal(etcBalance.getQty())+"]");
                    System.out.println("거래유형 - ["+ etcBalance.getTradeType()+"]");
                    System.out.println("매수금액 - ["+ new BigDecimal(etcBalance.getValAtTrade())+"]");
                    System.out.println("평가금액 - ["+ new BigDecimal(etcBalance.getValAtCur())+"]");
                    System.out.println("수익률 - [" + etcBalance.getEarningRate()+"%]");
                }
            }
        }
        {
            int totalCntInMsg = equityCnt + fundCnt + etcCnt;
            System.out.println("-------------------------------------");
            System.out.println("이번 메시지 내 총 종목건수 - [" + totalCntInMsg+"]");
            if (totalCntInMsg - queryResult.getCount() != 0) {
                System.out.println("보낼 종목수와 받은 종목수가 차이가 있음");
            }
        }
    }
}
