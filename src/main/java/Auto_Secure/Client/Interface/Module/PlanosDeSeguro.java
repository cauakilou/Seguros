package Auto_Secure.Client.Interface.Module;
/**
 * Enum que define os planos de seguro e a estratégia de cálculo para cada um.
 * Cada plano é responsável por saber como calcular seu próprio valor com base no
 * valor de um veículo.
 */
public enum PlanosDeSeguro {

    /**
     * Plano Básico: 5% do valor do veículo.
     */
    BASIC {
        @Override
        public double calcularValor(double valorBaseVeiculo) {
            return valorBaseVeiculo * 0.05;
        }
    },

    /**
     * Plano Básico Plus: 5% do valor do veículo + uma taxa fixa de R$ 150.
     */
    BASIC_PLUS {
        @Override
        public double calcularValor(double valorBaseVeiculo) {
            return (valorBaseVeiculo * 0.05) + 150.00;
        }
    },

    /**
     * Plano Médio: 7% do valor do veículo.
     */
    MEDIUM {
        @Override
        public double calcularValor(double valorBaseVeiculo) {
            return valorBaseVeiculo * 0.07;
        }
    },

    /**
     * Plano Médio Plus: 7% do valor do veículo + uma taxa fixa de R$ 250.
     */
    MEDIUM_PLUS {
        @Override
        public double calcularValor(double valorBaseVeiculo) {
            return (valorBaseVeiculo * 0.07) + 250.00;
        }
    },

    /**
     * Plano Premium: 10% do valor do veículo.
     */
    PREMIUM {
        @Override
        public double calcularValor(double valorBaseVeiculo) {
            return valorBaseVeiculo * 0.10;
        }
    },

    /**
     * Plano Premium Plus: 10% do valor do veículo + uma taxa fixa de R$ 400.
     */
    PREMIUM_PLUS {
        @Override
        public double calcularValor(double valorBaseVeiculo) {
            return (valorBaseVeiculo * 0.10) + 400.00;
        }
    };

    /**
     * Método abstrato que força cada plano a implementar sua própria lógica de cálculo.
     *
     * @param valorBaseVeiculo O valor do veículo obtido (ex: da Tabela FIPE).
     * @return O valor final do seguro calculado para este plano.
     */
    public abstract double calcularValor(double valorBaseVeiculo);
}