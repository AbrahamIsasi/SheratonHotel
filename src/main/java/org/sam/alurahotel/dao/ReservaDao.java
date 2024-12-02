package org.sam.alurahotel.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.sam.alurahotel.factory.ConnectionFactory;
import org.sam.alurahotel.modelo.Reserva;

public class ReservaDao {

	private final Connection con;

	public ReservaDao(Connection con) {
		this.con = con;
	}

	public void guardar(Reserva reserva) {
		try {
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO reservas(fecha_entrada, fecha_salida, valor, tipo_habitacion,num_habitacion, forma_pago, id_pago ) VALUES(?, ?, ?, ?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS
			);

			try (statement) {
				ejecutarReserva(reserva, statement);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void ejecutarReserva(Reserva reserva, PreparedStatement statement) throws SQLException {
		statement.setString(1, reserva.getFechaEntrada());
		statement.setString(2, reserva.getFechaSalida());
		statement.setLong(3, reserva.getValor());
		statement.setString(4, reserva.getTipoHabitacion());
		statement.setString(5,reserva.getNumeroHabitacion());
		statement.setString(6, reserva.getFormaPago());
		statement.setString(7, reserva.getEstadoReserva());


		statement.execute();

		try (ResultSet resultSet = statement.getGeneratedKeys()) {
			while (resultSet.next()) {
				reserva.setId(resultSet.getLong(1));
			}
		}
	}

	public List<Reserva> listarReservas(String campo) {
		List<Reserva> resultado = new ArrayList<>();
		String querySelect = "SELECT id, fecha_entrada, fecha_salida, valor, tipo_habitacion, num_habitacion, forma_pago, id_pago FROM reservas ";

		if (!campo.isEmpty()) {
			querySelect += "WHERE id = ? ";
		}

		querySelect += "ORDER BY id DESC;";

		try (PreparedStatement statement = con.prepareStatement(querySelect)) {
			if (!campo.isEmpty()) {
				statement.setLong(1, Long.valueOf(campo));
			}

			statement.execute();
			try (ResultSet resultSet = statement.getResultSet()) {
				while (resultSet.next()) {
					Reserva fila = new Reserva(
							resultSet.getLong("id"),
							resultSet.getString("fecha_entrada"),
							resultSet.getString("fecha_salida"),
							resultSet.getLong("valor"),
							resultSet.getString("tipo_habitacion"),
							resultSet.getString("num_habitacion"),
							resultSet.getString("forma_pago"),
							resultSet.getString("id_pago")

					);
					resultado.add(fila);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}


	public List<Reserva> listarTodasReservas() {
		List<Reserva> reservas = new ArrayList<>();
		String sql = "SELECT * FROM reservas";
		try (Connection conn = new ConnectionFactory().recupetaConexion();
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Reserva reserva = new Reserva(
						rs.getLong("id"),
						rs.getString("fecha_entrada"),
						rs.getString("fecha_salida"),
						rs.getLong("valor"),
						rs.getString("tipo_habitacion"),
						rs.getString("num_habitacion"),
						rs.getString("forma_pago"),
						rs.getString("id_pago")


				);
				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public int modificar(String fecha_entrada, String fecha_salida, Double valor, String tipo_habitacion, String num_habitacion, String forma_pago, String id_pago, Long id) {
		try {
			final PreparedStatement statement = con.prepareStatement(
					"UPDATE reservas SET fecha_entrada = ?, fecha_salida = ?, valor = ?, tipo_habitacion = ?, num_habitacion = ?, forma_pago = ?, id_pago = ? WHERE id = ?"
			);

			try (statement) {
				statement.setString(1, fecha_entrada);
				statement.setString(2, fecha_salida);
				statement.setDouble(3, valor);
				statement.setString(4, tipo_habitacion);
				statement.setString(5, num_habitacion);
				statement.setString(6, forma_pago);
				statement.setString(7, id_pago);
				statement.setLong(8, id);

				statement.execute();
				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int eliminar(Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM reservas WHERE id = ?");

			try (statement) {
				statement.setInt(1, id);
				statement.execute();
				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
