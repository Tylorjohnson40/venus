package venus.assembler.writers

import venus.assembler.InstructionWriter
import venus.riscv.Program
import venus.riscv.Instruction
import venus.riscv.InstructionField

object LoadWriter : InstructionWriter() {
    const val MAX_I_VALUE = 2047
    const val MIN_I_VALUE = -2048

    override operator fun invoke(prog: Program, inst: Instruction, args: List<String>) {
        checkArgsLength(args, 3)

        val rd = regNameToNumber(args[0])
        val rs1 = regNameToNumber(args[2])

        val imm = getImmediate(args[1], MIN_I_VALUE, MAX_I_VALUE)

        inst.setField(InstructionField.RD, rd)
        inst.setField(InstructionField.RS1, rs1)
        inst.setField(InstructionField.IMM_11_0, imm)
    }
}