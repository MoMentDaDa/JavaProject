package TransactionByAnno.Service;

public interface AccountServiceDao {

	void trans(Long outId, Long inId, int money);
}
